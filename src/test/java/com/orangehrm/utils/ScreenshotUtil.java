package com.orangehrm.utils;

import org.openqa.selenium.*;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String scenarioName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src,
                    new File("screenshots/" + scenarioName + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
