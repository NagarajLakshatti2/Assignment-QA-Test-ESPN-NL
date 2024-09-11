package com.espncricinfo.pages.livescores_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LiveScoreLocators {
    @FindBy(xpath = "//*[@name='&lpos=header_livescores' and text()='Results']")
    public WebElement resultsDropDownListItem;

    @FindBy(xpath = "//*[text()='Season view']")
    public WebElement seasonViewDropDownListItem;

    @FindBy(xpath = "//*[@name='&lpos=header_livescores' and text()='Desktop Scoreboard']")
    public WebElement desktopScoreboardDropDownListItem;
}
