package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.*;
import com.orangehrm.utils.DriverFactory;

public class DashboardPage extends BasePage {

    private By leaveMenu = By.xpath("//span[text()='Leave']");

    public DashboardPage() {
        super(DriverFactory.getDriver(), DashboardPage.class);
    }

    public void openLeaveModule() {
        click(leaveMenu);
    }
}
