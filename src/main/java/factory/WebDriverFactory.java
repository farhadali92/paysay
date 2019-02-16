package factory;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.WebEventListener;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static WebDriver WebDriver;
    protected static EventFiringWebDriver eventFiringWebDriver;
    protected static WebEventListener eventListener;


    public static WebDriver getWebDriver(String browserName) {
        WebDriver webDriver;

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unknown browser: " + browserName);
        }

        eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        eventListener = new WebEventListener(webDriver);
        eventFiringWebDriver.register(eventListener);
        webDriver = eventFiringWebDriver;

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
        return webDriver;
    }

}