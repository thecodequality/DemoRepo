package com.orangehrm.stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import com.orangehrm.pages.*;
import org.testng.Assert;

public class ApplyLeaveSteps {

    private MyLeavePage myLeavePage = new MyLeavePage();

    @When("User applies {string} leave from {string} to {string}")
    public void applyLeave(String leaveType, String from, String to) {
        new DashboardPage().openLeaveModule();
        new LeaveApplyPage().applyLeave(from, to, leaveType);
    }

    @Then("Leave status should be {string}")
    public void verifyStatus(String expectedStatus) {
        myLeavePage.clickMyLeaveTab();
        myLeavePage.keepOnlyFilter(expectedStatus);
        myLeavePage.clickSearch();
        String actualStatus = myLeavePage.getLeaveStatus(expectedStatus);
        Assert.assertEquals(actualStatus, expectedStatus);
    }


}