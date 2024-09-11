package com.espncricinfo.basepage;

import com.espncricinfo.drivers.DriverClass;
import com.espncricinfo.utils.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class BasePage {
    private final WebDriver driver;
    private final Duration duration;

    public BasePage() {
        this.driver = DriverClass.getDriver();
        PageFactory.initElements(DriverClass.getDriver(), this);
        int waitInSeconds = 5;
        duration = Duration.ofSeconds(waitInSeconds);
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForInVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(e));
    }

    public void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    public void waitForPresenceOfElement(By e) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(e));
    }

    public boolean isElementPresent(By e) {
        if (!driver.findElements(e).isEmpty()) {
            waitForVisibility(e);
            return true;
        } else
            return false;
    }

    public void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void click(WebElement e) {
        waitForVisibility(e);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(e));
        wait.until(ExpectedConditions.elementToBeClickable(e));
        e.click();
    }

    public void click(WebElement e, String msg) {
        waitForVisibility(e);
        e.click();
        Log4j.log.info(msg);
    }

    public void click(By e) {
        waitForVisibility(e);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.elementToBeClickable(e));
        driver.findElement(e).click();
    }

    public void clearAndSendKeys(WebElement e, String txt) throws InterruptedException {
        waitForVisibility(e);
        e.click();
        e.clear();
        e.click();
        Actions action = new Actions(driver);
        action.sendKeys(txt);
        action.build().perform();
    }

    public void sendKeys(WebElement e, String txt) throws InterruptedException {
        waitForVisibility(e);
        e.click();
        e.clear();
        e.sendKeys(txt);
    }

    public void sendKeys(WebElement e, String txt, String msg) {
        waitForVisibility(e);
        e.click();
        e.sendKeys(txt);
    }

    public String getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getAttribute(By e, String attribute) {
        waitForVisibility(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    public void ScrollDown() {
        //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }

    public void ScrollUp() {
        //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-350)", "");
    }

    public void ScrollDownUntilVisibility(WebElement element) {
        //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void ScrollDownToBottom(WebElement element) {
        //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public boolean find(final WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, duration);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return element.isDisplayed();
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public boolean find(final By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, duration);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return driver.findElement(element).isDisplayed();
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement waitTillPageLoad(WebElement loadingElement) {
        FluentWait<WebDriver> wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);

        WebElement myElement;
        myElement = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver androidDriver) {
                return (WebElement) loadingElement;
            }
        });
        return myElement;
    }


    public By waitTillPageLoadBy(By loadingElement) {
        FluentWait<WebDriver> wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);

        By myElement;
        myElement = wait.until(new Function<WebDriver, By>() {
            @Override
            public By apply(WebDriver androidDriver) {
                return (By) loadingElement;
            }
        });
        return myElement;
    }

    public void lowWait() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    public void medWait() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }

    public void highWait() throws InterruptedException {
        TimeUnit.SECONDS.sleep(8);
    }

    public void maxWait() throws InterruptedException {
        TimeUnit.SECONDS.sleep(12);
    }

}

