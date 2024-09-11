package com.espncricinfo.actions.livescores_actions.seasonview_actions;

import com.espncricinfo.basepage.BasePage;
import com.espncricinfo.hooks.Hooks;
import com.espncricinfo.pages.livescores_pages.SeasonViewLocators;
import com.espncricinfo.utils.KeyContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.PageFactory;

import static com.espncricinfo.drivers.DriverClass.getDriver;

public class SeasonViewActions {

    private final BasePage basePage;
    private final SeasonViewLocators seasonViewLocators;

    Hooks hooks;

    public SeasonViewActions() {
        this.hooks = new Hooks();
        this.basePage = new BasePage();
        this.seasonViewLocators = new SeasonViewLocators();
        PageFactory.initElements(getDriver(), seasonViewLocators);
    }

    public void searchMatch(String matchCountryName) throws InterruptedException {
        basePage.sendKeys(seasonViewLocators.seasonViewSearchMatch, matchCountryName);
        basePage.click(seasonViewLocators.seasonViewSearchMatchIcon, "search icon clicked");
    }

    public void verifySeasonViewVerifyMatchTypeTitle() {
        seasonViewLocators.seasonViewVerifyMatchTypeTitle.isDisplayed();
        /* SoftAssert below written when multiple elements text validation as expected.
         * */

//        var matchTitle = seasonViewLocators.seasonViewVerifyMatchTypeTitle.getText();
//        assertAll(KeyContext.get("cricketMatchTitles"),
//                () -> assertEquals(KeyContext.get("oneDayinternationalTourCricket"), matchTitle, "One-Day Internationals failing intensely"),
//                () -> assertEquals(KeyContext.get("oneDayinternationalTourCricket").toUpperCase(), matchTitle, "ONE-DAY INTERNATIONALS"),
//                () -> assertNotNull(matchTitle)
//        );
    }

    public void validateMatchInValidText() {
        basePage.waitForVisibility(seasonViewLocators.seasonViewSearchMatchInValidText);
        /* HardAssert below written when multiple elements text validation as expected.
         * */
        Assertions.assertEquals(KeyContext.get("searchCricketMatchCountryInValidText"), seasonViewLocators.seasonViewSearchMatchInValidText.getText());
        hooks.customTakeScreenshot();
    }
}
