import faker from "@faker-js/faker";
import * as Puppeteer from "puppeteer";

const realUserAgentHeader =
  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36";

async function getRandomHtmlByGoogleSearching(keyword) {
  const browser = await Puppeteer.launch({ headless: false });
  const page = await browser.newPage();
  await page.goto("https://www.google.com/");

  const acceptCookiesButton = await page.waitForXPath(
    "(//button[.//div[@role='none']])[4]"
  );

  await acceptCookiesButton.click();

  const searchInput = await page.$("input[name='q']");
  await searchInput.type(`${keyword} blog`);
  await page.$eval("form[action='/search']", (form) => form.submit());
  await page.waitForNavigation();
  const link = await page.waitForSelector("div#search a");
  const href = await link.getProperty("href");
  const jsonHref = await href.jsonValue();
  const blogUrl: string = String(jsonHref);
  console.log(blogUrl);

  await page.close();

  const blogPage = await browser.newPage();
  await blogPage.setUserAgent(realUserAgentHeader);
  await blogPage.goto(blogUrl);

  await blogPage.setRequestInterception(true);

  blogPage.on("requestfailed", (request) => {
    console.log(
      `url: ${request.url()}, errText: ${
        request.failure().errorText
      }, method: ${request.method()}`
    );
  });

  const content = await blogPage.content();
  try {
    return content;
  } finally {
    await blogPage.close();
    await browser.close();
  }
}

async function getRandomHtmlByGoogleSearchingByTryingSeveralKeywords() {
  let hasSucceeded = false;
  while (!hasSucceeded) {
    try {
      const keyword = faker.word.noun();
      const result = await getRandomHtmlByGoogleSearching(keyword);
      return result;
    } catch (e) {
      hasSucceeded = false;
    }
  }
}

export default getRandomHtmlByGoogleSearchingByTryingSeveralKeywords;
