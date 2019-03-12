package utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.AbstractPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestUtil {

    static String projectPath= System.getProperty("user.dir");


    public static void waitInSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(projectPath + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

}
