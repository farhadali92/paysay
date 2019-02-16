package utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.AbstractPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestUtil extends AbstractPage {

    static String projectPath= System.getProperty("user.dir");

    public TestUtil(WebDriver driver) {
        super(driver);
    }


    public static void waitInSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {

        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(projectPath + "/screenshots/" + System.currentTimeMillis() + ".png"));

    }

}
