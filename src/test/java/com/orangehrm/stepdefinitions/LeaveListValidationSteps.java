package com.orangehrm.stepdefinitions;

import io.cucumber.java.en.*;
import com.orangehrm.pages.LeaveListPage;
import com.orangehrm.utils.DriverFactory;
import org.testng.Assert;

public class LeaveListValidationSteps {

    LeaveListPage list = new LeaveListPage(DriverFactory.getDriver());

    @Then("Leave should appear in Leave List")
    public void verifyLeaveInList() {
        list.openLeaveList();
        list.searchLeave();
        Assert.assertTrue(list.isLeavePresent(), "Leave not found in Leave List");
    }
}
