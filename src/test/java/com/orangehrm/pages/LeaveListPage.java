package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.*;
import com.orangehrm.utils.DriverFactory;

public class LeaveListPage extends BasePage {

    private By leaveListTab = By.xpath("//a[text()='Leave List']");
    private By searchBtn = By.xpath("//button[text()='Search']");
    private By firstRow = By.xpath("//div[@role='row'][2]");

    public LeaveListPage(WebDriver driver) {
        super(DriverFactory.getDriver(), LeaveListPage.class);
    }

    public void openLeaveList() {
        click(leaveListTab);
    }

    public void searchLeave() {
        click(searchBtn);
    }

    public boolean isLeavePresent() {
        log.info("Checking if leave exists in Leave List");
        return isElementVisible(firstRow);
    }
}