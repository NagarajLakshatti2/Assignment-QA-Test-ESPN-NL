package com.espncricinfo.stepdef.livescores;


import com.espncricinfo.actions.livescores_actions.LiveScoresActions;
import com.espncricinfo.actions.livescores_actions.seasonview_actions.SeasonViewActions;
import com.espncricinfo.basepage.BasePage;
import com.espncricinfo.drivers.DriverClass;
import com.espncricinfo.globalparameters.GlobalParameters;
import com.espncricinfo.hooks.Hooks;
import com.espncricinfo.utils.KeyContext;
import com.userprofiledata.ReadUserTestData;
import io.cucumber.java.en.*;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LiveCricketScoresSteps {

    private LiveScoresActions liveScoresActions;
    private SeasonViewActions seasonViewActions;
    private KeyContext keyContext;
    private ReadUserTestData readUserTestData;
    private GlobalParameters parameters;
    private Hooks hooks;

    public LiveCricketScoresSteps() throws IOException, URISyntaxException {
        this.hooks = new Hooks();
        this.parameters = new GlobalParameters();
        this.keyContext = new KeyContext();
        this.readUserTestData = new ReadUserTestData();

        this.liveScoresActions = new LiveScoresActions();
        this.seasonViewActions = new SeasonViewActions();
    }

    @Given("Launch espncricinfo application")
    public void launchEspncricinfoApplication() throws IOException, URISyntaxException {
        readUserTestData.setTestDataContext();
        DriverClass.openPage(keyContext.get("espncricinfo_url"));
        hooks.cucumberReportLog("Browser Name: "+parameters.getBrowserName());
        hooks.cucumberReportLog("URL: "+keyContext.get("espncricinfo_url"));
    }

    @Given("Navigate to the live scores menu option")
    public void navigate_to_the_live_scores_menu_option() throws InterruptedException, AWTException {
        liveScoresActions.navigateToLiveScoresDropDownMenuOption();
    }

    @When("Tap on the drop-down list of items labeled season view")
    public void tap_on_the_drop_down_list_of_items_labeled() throws InterruptedException {
        liveScoresActions.tapOnSeasonViewDropDownListItem();
    }

    @Then("Tap on the search icon after enter the country {string} in the search match field")
    public void tapOnTheSearchIconAfterEnterTheCountryNameInTheSearchMatchField(String country) throws InterruptedException {
        seasonViewActions.searchMatch(country);
    }

    @Then("Tap on the search icon after enter the country names {} in the search match field")
    public void tapOnTheSearchIconAfterEnterTheCountryNamesInTheSearchMatchField(String country) throws InterruptedException {
        seasonViewActions.searchMatch(country);
    }
}
