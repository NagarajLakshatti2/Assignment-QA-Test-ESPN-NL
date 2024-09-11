package com.espncricinfo.actions.livescores_actions;

import com.espncricinfo.basepage.BasePage;
import com.espncricinfo.pages.headers_pages.HeadersLocators;
import com.espncricinfo.pages.livescores_pages.LiveScoreLocators;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static com.espncricinfo.drivers.DriverClass.getDriver;

public class LiveScoresActions extends HeadersLocators {

    private HeadersLocators headersLocators;
    private LiveScoreLocators liveScoreLocators;
    private Actions actions;
    private BasePage basePage;

    public LiveScoresActions() {
        this.basePage = new BasePage();
        this.headersLocators = new HeadersLocators();
        this.liveScoreLocators = new LiveScoreLocators();
        PageFactory.initElements(getDriver(), headersLocators);
        PageFactory.initElements(getDriver(), liveScoreLocators);
        this.actions = new Actions(getDriver());
    }

    public void navigateToLiveScoresDropDownMenuOption() {
        basePage.waitForVisibility(headersLocators.liveScoresHeader);
        actions.moveToElement(headersLocators.liveScoresHeader).build().perform();
    }

    public void tapOnSeasonViewDropDownListItem() throws InterruptedException {
        basePage.click(liveScoreLocators.seasonViewDropDownListItem);
    }
}
