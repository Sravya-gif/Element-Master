package com.srm.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {

        try {
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

            File dest = new File(path);
            dest.getParentFile().mkdirs(); // 🔥 create folder if not exists

            FileUtils.copyFile(src, dest);

            return path;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}