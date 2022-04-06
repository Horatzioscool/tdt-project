import {Builder} from 'selenium-webdriver';

(async function helloSelenium() {
  let driver = await new Builder().forBrowser('chrome').build();

  await driver.get('https://lighthouse-demo.evozon.com/login');

  await driver.quit();
})();
