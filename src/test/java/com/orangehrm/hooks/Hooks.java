package com.orangehrm.hooks;

import io.cucumber.java.*;
import com.orangehrm.utils.*;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static final Logger log =
            LoggerUtil.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        log.info("========== START SCENARIO: " + scenario.getName() + " ==========");
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.get("url"));
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            log.error("SCENARIO FAILED: " + scenario.getName());
            ScreenshotUtil.capture(
                    DriverFactory.getDriver(),
                    scenario.getName().replace(" ", "_")
            );
        }
        log.info("========== END SCENARIO: " + scenario.getName() + " ==========");
        DriverFactory.quitDriver();
    }
}