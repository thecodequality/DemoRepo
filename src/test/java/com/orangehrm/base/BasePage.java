package com.orangehrm.base;

import org.openqa.selenium.*;
import org.apache.logging.log4j.Logger;
import com.orangehrm.utils.*;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;
    protected Logger log;

    public BasePage(WebDriver driver, Class<?> clazz) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        this.log = LoggerUtil.getLogger(clazz);
    }

    protected void click(By locator) {
        try {
            wait.waitAndClick(locator);
        } catch (ElementClickInterceptedException e) {
            log.warn("Click intercepted, retrying with JS click: " + locator);
            jsClick(locator);
        }
    }
    protected void jsClick(By locator) {
        WebElement element = wait.waitForVisible(locator);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true); arguments[0].click();",
                element
        );
    }

    protected void clearAndTypeDate(By locator, String date) {

        WebElement element = wait.waitForVisible(locator);
        element.click();

        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(date);

        element.sendKeys(Keys.TAB);

        log.info("Entered date: " + date);
    }


    protected String getText(By locator) {
        String text = wait.waitForVisible(locator).getText();
        log.info("Reading text '" + text + "' from: " + locator);
        return text;
    }
    protected boolean isElementVisible(By locator) {
        try {
            wait.waitForVisible(locator);
            log.info("Element visible: " + locator);
            return true;
        } catch (TimeoutException e) {
            log.warn("Element not visible: " + locator);
            return false;
        }
    }

    protected void waitShort() {
        try {
            Thread.sleep(300); // controlled, minimal wait
        } catch (InterruptedException ignored) {}
    }

    protected void clickOutside() {
        // Click page header area to close any open overlay
        By header = By.xpath("//header");
        driver.findElement(header).click();
        log.info("Clicked outside to close overlays");
    }


}
