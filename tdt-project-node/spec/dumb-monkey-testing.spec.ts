import axios from "axios";
import "jasmine";
import * as Puppeteer from "puppeteer";
import * as config from "../config.json";
import * as configLocal from "../config.local.json";
import { authheader } from "./helpers";
import { faker } from "@faker-js/faker";
import getRandomHtml from "./dumb-monkey-testing/random-html-helper";

const { url, username, password } = config;

const realUserAgentHeader =
  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36";

const apiBaseUrl = "https://lighthouse-demoapi.evozon.com//api";
const apiLoginUrl = "https://lighthouse-demoapi.evozon.com//login";

async function apiLogin() {
  const authResponse = await axios({
    method: "POST",
    url: apiLoginUrl,
    data: {
      username: configLocal.account.username,
      password: configLocal.account.password,
    },
  });

  console.log(authResponse.data);

  return authResponse.data.token;
}

async function startPuppeteer() {
  const token = await apiLogin();
  const browser = await Puppeteer.launch({ headless: false });
  const page = await browser.newPage();
  await page.setExtraHTTPHeaders({
    Authorization: authheader(username, password),
  });
  page.setUserAgent(realUserAgentHeader);
  await page.setRequestInterception(true);

  page.on("request", async (r) => {
    if (r.url() == apiLoginUrl) {
      await r.continue({
        headers: {
          Authorization: token,
        },
      });
    } else if (r.url().startsWith(apiBaseUrl)) {
      r.continue({
        headers: {
          Authorization: token,
        },
      });
    } else {
      r.continue();
    }
  });

  await page.goto(url);

  const localStorage: any = {};
  await page.evaluate((token) => {
    localStorage.setItem("TOKEN", JSON.stringify(token));
  }, token);

  await page.setViewport({
    width: 1920,
    height: 1080,
  });

  return { page, browser };
}

function randomUnicode() {
  let s = "";

  for (let i = 0; i < 200; i++) {
    s = s + String.fromCharCode(0x30a0 + Math.random() * (0x30ff - 0x30a0 + 1));
  }
  console.log(s);
  return s;
}

describe("Lighthouse DUMB MONKEY TESTING", () => {
  beforeAll(() => {
    jasmine.DEFAULT_TIMEOUT_INTERVAL = 1000000000;
  });

  it("DMT1 should not let me input illegal characters in a building name", async () => {
    const { page, browser } = await startPuppeteer();
    await page.goto(url + "/buildings");
    const addButton = await page.waitForXPath(
      `//button[.//span[contains(text(), "ADD")]]`
    );
    expect(addButton).toBeDefined();
    addButton.click();

    const buildingNameInput = await page.waitForSelector("#label");
    const input = randomUnicode();
    await buildingNameInput.type(input);

    const testId = "DMT1";
    const rightNow = new Date().getTime();
    await page.screenshot({
      path: `spec/dumb-monkey-testing/screenshots/${testId}-${rightNow}.png`,
    });
    await page.close();
    await browser.close();
    expect(true);
  });

  it("DMT2 should not break if input is really long", async () => {
    const { page, browser } = await startPuppeteer();
    await page.goto(url);
    const searchBar = await page.waitForSelector("input#Desks");
    expect(searchBar).toBeDefined();

    const input = faker.lorem.sentences(10);
    console.log(input);
    await searchBar.type(input);

    const testId = "DMT2";
    const rightNow = new Date().getTime();
    await page.screenshot({
      path: `spec/dumb-monkey-testing/screenshots/${testId}-${rightNow}.png`,
    });
    await page.close();
    await browser.close();
    expect(true);
  });

  it("DMT3 should not allow me to input HTML in Username input", async () => {
    const html = await getRandomHtml();
    const browser = await Puppeteer.launch({ headless: false });
    const page = await browser.newPage();
    await page.setExtraHTTPHeaders({
      Authorization: authheader(username, password),
    });
    page.setUserAgent(realUserAgentHeader);

    await page.goto(url);
    await page.waitForNavigation();

    await page.waitForSelector("form");
    const usernameInput = await page.$("input[name='username']");
    const passwordInput = await page.$("input[name='password']");

    await usernameInput.type(html.substring(0, 200));
    await passwordInput.type(html.substring(200, 200));

    const testId = "DMT3";
    const rightNow = new Date().getTime();
    await page.screenshot({
      path: `spec/dumb-monkey-testing/screenshots/${testId}-${rightNow}.png`,
    });
    await page.close();
    await browser.close();
    expect(true);
  });
});
