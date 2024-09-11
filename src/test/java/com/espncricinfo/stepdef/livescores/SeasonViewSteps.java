package com.espncricinfo.stepdef.livescores;

import com.espncricinfo.actions.livescores_actions.seasonview_actions.SeasonViewActions;
import io.cucumber.java.en.And;
import org.opentest4j.MultipleFailuresError;

public class SeasonViewSteps {
    SeasonViewActions seasonViewActions;

    public SeasonViewSteps()  {
        seasonViewActions = new SeasonViewActions();
    }
    @And("Verify match details")
    public void verifyMatchTypeIsDisplay() {
        seasonViewActions.verifySeasonViewVerifyMatchTypeTitle();
    }

    @And("Validate invalid match text as no matches found for this season")
    public void validateInvalidMatchText() throws InterruptedException {
        seasonViewActions.validateMatchInValidText();
    }
}
