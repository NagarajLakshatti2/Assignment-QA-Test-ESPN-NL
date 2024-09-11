package com.espncricinfo.pages.livescores_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeasonViewLocators {
    @FindBy(xpath = "//input[@type='search']")
    public WebElement seasonViewSearchMatch;

    @FindBy(xpath = "//*[@class='no-matches']")
    public WebElement seasonViewSearchMatchInValidText;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement seasonViewSearchMatchIcon;

    @FindBy(xpath = "//div[@class='match-section-head']/h2")
    public WebElement seasonViewVerifyMatchTypeTitle;

}
