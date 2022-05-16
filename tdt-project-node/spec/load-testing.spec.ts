import { Ensure } from "@serenity-js/assertions";
import { exec } from "child_process";
import * as fs from "fs/promises";
import Mustache = require("mustache");
import * as config from "../config.json";
import { authheader } from "./helpers";

interface ArtilleryScriptConfig {
  arrivalRate: number;
  duration: number;
  url: URL;
  authheader: string;
}

interface ArtilleryReport {
  aggregate: {
    counters: {
      "http.requests": number;
      "http.200.codes": number;
      "http.responses": number;
    };
    summaries: {
      "http.response_time": {
        min: number;
        median: number;
        max: number;
      };
    };
  };
}

const scripteFileTemplate = `spec/load-testing/load-testing.yaml.mustache`;
const scriptFile = `spec/load-testing/load-testing.yaml`;
const reportFile = `spec/load-testing/report.json`;

xdescribe("Lighthouse LOAD TEST", () => {
  let originalTimeout;
  beforeAll(() => {
    originalTimeout = jasmine.DEFAULT_TIMEOUT_INTERVAL;
    jasmine.DEFAULT_TIMEOUT_INTERVAL = 1000000000;
  });

  const loadTest1Config: ArtilleryScriptConfig = {
    arrivalRate: 200,
    duration: 30,
    authheader: authheader(config.username, config.password),
    url: new URL(config.url),
  };

  it(`LT1 should respond with ok to all requests while under ${loadTest1Config.arrivalRate} r/s`, async () => {
    const buffer = await fs.readFile(scripteFileTemplate);
    const template = await buffer.toString();

    const script = Mustache.render(template, loadTest2Config);
    console.log(script);

    await fs.writeFile(scriptFile, script);

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

    const requestCount = report.aggregate.counters["http.requests"];
    const responseCount = report.aggregate.counters["http.responses"];
    const okResponseCount = report.aggregate.counters["http.codes.200"];
    expect(requestCount).toBeDefined();
    expect(responseCount).toBeDefined();
    expect(okResponseCount).toBeDefined();

    expect(responseCount).toEqual(requestCount);
    expect(okResponseCount).toEqual(responseCount);
  });

  const loadTest2MaxResponseTimeMs = 450;
  const loadTest2Config: ArtilleryScriptConfig = {
    arrivalRate: 5,
    duration: 30,
    authheader: authheader(config.username, config.password),
    url: new URL(config.url),
  };

  it(`LT2 should load login page in under ${loadTest2MaxResponseTimeMs} ms while under ${loadTest2Config.arrivalRate} r/s`, async () => {
    const buffer = await fs.readFile(scripteFileTemplate);
    const template = await buffer.toString();

    const script = Mustache.render(template, loadTest2Config);
    console.log(script);

    await fs.writeFile(scriptFile, script);

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
      report.aggregate.summaries["http.response_time"].median;

    expect(maxResponseTime).toBeLessThanOrEqual(loadTest2MaxResponseTimeMs);
  });

  afterAll(() => {
    jasmine.DEFAULT_TIMEOUT_INTERVAL = originalTimeout;
  });
});
