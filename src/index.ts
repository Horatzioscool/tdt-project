import * as puppeteer from 'puppeteer';

async function helloPuppeteer() {
  const browser = await puppeteer.launch();
  const page = await browser.newPage();
  await page.goto('https://lighthouse-demo.evozon.com/login');

  await page.screenshot({path: 'example.png'});

  await browser.close();
}

helloPuppeteer();
