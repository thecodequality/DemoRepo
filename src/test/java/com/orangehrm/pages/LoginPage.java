package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.*;
import com.orangehrm.utils.DriverFactory;

public class LoginPage extends BasePage {

    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//button[normalize-space()='Login']");

    public LoginPage() {
        super(DriverFactory.getDriver(), LoginPage.class);
    }

    public void login(String user, String pass) {
        log.info("Logging into application");
        clearAndTypeDate(username, user);
        clearAndTypeDate(password, pass);
        click(loginBtn);
    }
}
