import { exec } from "child_process";
import * as fs from "fs/promises";
import Mustache = require("mustache");
import * as config from "../config.json";
import * as loadTestingConfig from "./load-testing/load-testing.config.json";

interface ArtilleryReport {
  aggregate: {
    summaries: {
      "http.response_time": {
        min: number;
        max: number;
      };
    };
  };
}

const scripteFileTemplate = `spec/load-testing/load-testing.yaml.mustache`;
const scriptFile = `spec/load-testing/load-testing.yaml`;
const reportFile = `spec/load-testing/report.json`;

describe("Lighthouse LOAD TEST", () => {
  let originalTimeout;
  beforeAll(() => {
    originalTimeout = jasmine.DEFAULT_TIMEOUT_INTERVAL;
    jasmine.DEFAULT_TIMEOUT_INTERVAL = 1000000000;
  });

  it("lets us access the login page", async () => {
    const buffer = await fs.readFile(scripteFileTemplate);
    const template = await buffer.toString();

    const artilleryConfig = Mustache.render(template, {
      ...loadTestingConfig,
      authheader: "",
      url: config.url,
    });

    const artillery = exec(
      `npx artillery run --output ${reportFile} ${scriptFile}`,
      (e, output) => {
        if (e) fail(e);
        console.log(output);
      }
    );

    artillery.on("error", (e) => fail(e));

    await new Promise((resolve) => {
      artillery.on("close", resolve);
    });

    const report: ArtilleryReport = await import(
      `${__dirname}/load-testing/report.json`
    );

    const maxResponseTime =
      report.aggregate.summaries["http.response_time"].max;

    expect(maxResponseTime).toBeLessThanOrEqual(500);
  });

  afterAll(() => {
    jasmine.DEFAULT_TIMEOUT_INTERVAL = originalTimeout;
  });
});
