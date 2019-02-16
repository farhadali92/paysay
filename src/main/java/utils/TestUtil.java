package utils;

import org.openqa.selenium.WebDriver;
import pages.AbstractPage;

public class TestUtil {

    public static void waitInSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
