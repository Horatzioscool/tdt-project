import { exec } from "child_process";

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

describe("Lighthouse App", () => {
  let originalTimeout;

  beforeAll(() => {
    originalTimeout = jasmine.DEFAULT_TIMEOUT_INTERVAL;
    jasmine.DEFAULT_TIMEOUT_INTERVAL = 1000000000;
  });

  it("lets us book desks", async () => {
    const scriptFile = `spec/load-testing/test.yaml`;
    const reportFile = `spec/load-testing/report.json`;
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
