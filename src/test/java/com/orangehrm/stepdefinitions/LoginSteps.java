package com.orangehrm.stepdefinitions;

import io.cucumber.java.en.*;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ConfigReader;

public class LoginSteps {

    @Given("User logs into OrangeHRM")
    public void login() {
        new LoginPage()
                .login(
                        ConfigReader.get("username"),
                        ConfigReader.get("password")
                );
    }
}
