package com.orangehrm.stepdefinitions;

import io.cucumber.java.en.*;
import com.orangehrm.pages.MyLeavePage;

public class CancelLeaveSteps {

    @And("User cancels the leave")
    public void cancelLeave() {
        new MyLeavePage().cancelLeave();
    }
}