package com.espncricinfo.hooks;

import com.espncricinfo.acceptancetests.RetryRule;
import com.espncricinfo.drivers.DriverClass;
import com.espncricinfo.globalparameters.GlobalParameters;
import com.espncricinfo.utils.Log4j;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Rule;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.espncricinfo.drivers.DriverClass.*;

public class Hooks {
    public static Scenario scenarioName;

    private Log4j log4j;

    public Hooks() {
    }

    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Before()
    public void before(Scenario scenario) throws IOException, URISyntaxException {
        this.scenarioName = scenario;
        this.log4j = new Log4j();
        GlobalParameters globalParameters = new GlobalParameters();
        globalParameters.initializeGlobalParams();
        setUpDriver();
        Log4j.log.info("Before: Execute method before each scenario");
    }

    @After()
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            customTakeScreenshot();
            Log4j.log.info("After: Execute method after each scenario and if fail taken screenshot");
        }
        tearDown();
    }

    //Add this notification to your Test Class
    public void customTakeScreenshot() {
        byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenarioName.attach(screenshot, "image/png", scenarioName.getName());
    }

    public void cucumberReportLog(String message) {
        scenarioName.log(message);
    }

}
