package com.espncricinfo.pages.headers_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeadersLocators {
    @FindBy(xpath = "//*[text()='Live Scores']")
    public WebElement liveScoresHeader;
}
