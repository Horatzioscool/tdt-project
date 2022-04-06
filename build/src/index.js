"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const selenium_webdriver_1 = require("selenium-webdriver");
(async function helloSelenium() {
    let driver = await new selenium_webdriver_1.Builder().forBrowser('chrome').build();
    await driver.get('https://lighthouse-demo.evozon.com/login');
    await driver.quit();
})();
//# sourceMappingURL=index.js.map