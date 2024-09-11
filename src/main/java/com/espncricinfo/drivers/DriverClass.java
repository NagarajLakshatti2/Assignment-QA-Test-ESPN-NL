package com.espncricinfo.drivers;

import com.espncricinfo.globalparameters.GlobalParameters;
import com.espncricinfo.utils.Log4j;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.time.Duration;

public class DriverClass {
    private static DriverClass driverClass;
    private static WebDriver driver;
    public final static int TIMEOUT = 7;

    GlobalParameters globalParameters = new GlobalParameters();
    DesiredCapabilities desiredCapabilities;
    ChromeOptions chromeOptions;

    private DriverClass() throws MalformedURLException {
        switch (globalParameters.getBrowserName()) {
            case "chrome":
                // browser working fine
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setPlatform(Platform.WIN10);
                chromeOptions = new ChromeOptions();
//                driver = new RemoteWebDriver((new URL("http://192.168.17.78:4444")), chromeOptions);
                break;
            case "edge":
                // browser working fine
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                // browser not installed
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                // browser not installed
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                // IOS OS browser not tested
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case "opera":
                // browser not installed
                WebDriverManager.operadriver().setup();
                driver = (WebDriver) new OperaDriverManager();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }

    public static void setUpDriver() throws MalformedURLException {
        if (driverClass == null) {
            Log4j.log.info("setUpDriver");
            driverClass = new DriverClass();
        }
    }

    public static WebDriver getDriver() {
        Log4j.log.info("getDriver");
        return driver;
    }

    public static void openPage(String url) throws MalformedURLException {
        Log4j.log.info("url: " + url);
        driver.get(url);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        driverClass = null;
        Log4j.log.info("tearDown");
    }



}
