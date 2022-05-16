import "jasmine";
import * as Puppeteer from "puppeteer";
import * as config from "../config.json";
import { authheader } from "./helpers";

const { url, username, password } = config;

xdescribe("Lighthouse App", () => {
  it("lets us book desks", async () => {
    const browser = await Puppeteer.launch({ headless: false });
    const page = await browser.newPage();
    await page.setExtraHTTPHeaders({
      authorization: authheader(username, password),
    });
    await page.goto(url);

    const title = await page.title();
    expect(title).toContain("Lighthouse");
  });
});
