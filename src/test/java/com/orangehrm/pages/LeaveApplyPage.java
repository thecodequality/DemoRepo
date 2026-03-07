package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.*;
import com.orangehrm.utils.DriverFactory;
import org.openqa.selenium.interactions.Actions;

public class LeaveApplyPage extends BasePage {

    private By applyTab = By.xpath("//a[text()='Apply']");
    private By leaveTypeDropdown = By.xpath("//label[normalize-space()='Leave Type']/following::div[contains(@class,'oxd-select-text')][1]");
    private By fromDate = By.xpath("//label[text()='From Date']/following::input[1]");
    private By toDate = By.xpath("//label[text()='To Date']/following::input[1]");
    private By comment = By.tagName("textarea");
    private By applyBtn = By.xpath("//button[normalize-space()='Apply']");
    private static final int SICK_LEAVE = 1;
    private Actions actions;

    public LeaveApplyPage() {
        super(DriverFactory.getDriver(), LeaveApplyPage.class);
        this.actions = new Actions(driver);
    }

    public void selectLeaveTypeUsingKeyboard(int downArrowCount) {

        log.info("Selecting leave type using keyboard via Actions. Down arrows: " + downArrowCount);

        // Click dropdown to bring focus
        click(leaveTypeDropdown);

        if (downArrowCount <= 0) {
            throw new IllegalArgumentException("Arrow count must be > 0");
        }

        for (int i = 0; i < downArrowCount; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            waitShort();
        }

        actions.sendKeys(Keys.ENTER).perform();
    }



    public void applyLeave(String from, String to, String leaveType) {
        click(applyTab);
        selectLeaveTypeUsingKeyboard(SICK_LEAVE);
        clearAndTypeDate(fromDate, from);
        clearAndTypeDate(toDate, to);
        clickOutside();
        clearAndTypeDate(comment, "Applying " + leaveType);
        click(applyBtn);
    }
}
