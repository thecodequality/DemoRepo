package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.*;
import com.orangehrm.utils.DriverFactory;

import java.util.List;

public class MyLeavePage extends BasePage {

    private By myLeaveTab = By.xpath("//a[text()='My Leave']");
    private By cancelBtn = By.xpath("//button[text()='Cancel']");
    private By selectedStatusChips = By.xpath("//span[contains(@class,'oxd-chip')]");
    private By statusDropdown = By.xpath("//label[text()='Show Leave with Status']/following::div[contains(@class,'oxd-select-text')][1]");
    private By requiredFilter(String filterName) {
        return By.xpath("//span[contains(@class,'oxd-chip') and text()='" + filterName + "']");
    }
    private By filterCloseIcon= By.xpath("//span[contains(@class,'oxd-chip')]/i[1]");
    private By searchBtn = By.xpath("//button[normalize-space()='Search']");

    public MyLeavePage() {
        super(DriverFactory.getDriver(), MyLeavePage.class);
    }
    public void clickMyLeaveTab() {
        log.info("Clicking My Leave Tab");
        click(myLeaveTab);
    }

    public  String getLeaveStatus(String expectedStatus) {

        WebElement statusElement = wait.waitForVisible(requiredFilter(expectedStatus));

        log.info("Leave status found: " + statusElement.getText());
        return statusElement.getText();
    }

    public void cancelLeave() {
        click(myLeaveTab);
        click(cancelBtn);
    }

    private void selectStatusFromDropdown(String status) {

        click(statusDropdown);

        WebElement active = driver.switchTo().activeElement();
        active.sendKeys(status);
        active.sendKeys(Keys.ENTER);

        waitShort();
    }
    public void keepOnlyFilter(String filterToKeep) {

        log.info("Keeping only filter: " + filterToKeep);

        // All selected filter spans (chips)
        List<WebElement> selectedFilters = driver.findElements(selectedStatusChips);

        for (WebElement filter : selectedFilters) {

            String filterText = filter.getText().trim();

            // If this is NOT the filter we want to keep → remove it
            if (!filterText.equalsIgnoreCase(filterToKeep)) {

                log.info("Removing filter: " + filterText);

                // Click the close icon inside the span
                WebElement closeIcon = filter.findElement(filterCloseIcon);
                closeIcon.click();

                waitShort();
            }
        }
    }

    public void clickSearch() {
        click(searchBtn);
    }
}
