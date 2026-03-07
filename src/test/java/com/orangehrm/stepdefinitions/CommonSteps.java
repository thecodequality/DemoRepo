package com.orangehrm.stepdefinitions;

import io.cucumber.java.en.*;
import com.orangehrm.utils.DriverFactory;

public class CommonSteps {

    @When("User refreshes the page")
    public void refreshPage() {
        DriverFactory.getDriver().navigate().refresh();
    }
}
