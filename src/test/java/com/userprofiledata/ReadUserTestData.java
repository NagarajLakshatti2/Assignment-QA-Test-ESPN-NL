package com.userprofiledata;

import com.espncricinfo.utils.ContentContext;
import com.espncricinfo.utils.Log4j;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ReadUserTestData {
    private final ContentContext contentContext;
    private JsonNode jsonNode = null;

    public ReadUserTestData() {
        this.contentContext = new ContentContext();
    }

    public void setTestDataContext() throws IOException, URISyntaxException {

        File readFile = new File(System.getProperty("user.dir") + File.separator + "testdata" + File.separator + "seasonview.json");
        jsonNode = UserDataCollections.getFileFromResource(String.valueOf(readFile));

        contentContext.set("espncricinfo_url", jsonNode.get("espncricinfo_url").asText());
        contentContext.set("searchCricketMatchCountry", jsonNode.get("searchCricketMatchCountry").asText());
        contentContext.set("cricketMatchTitles", jsonNode.get("cricketMatchTitles").get("cricketMatchTitles").asText());
        contentContext.set("oneDayinternationalTourCricket", jsonNode.get("cricketMatchTitles").get("oneDayinternationalTourCricket").asText());
        contentContext.set("twenty20internationalTourCricket", jsonNode.get("cricketMatchTitles").get("twenty20internationalTourCricket").asText());
        contentContext.set("searchCricketMatchCountryInValidText", jsonNode.get("searchCricketMatchCountryInValidText").asText());

        contentContext.set("searchInvalidTextValidation", jsonNode.get("seasonView").get("searchInvalidTextValidation").asText());

        Log4j.log.info(contentContext.get("espncricinfo_url"));
        Log4j.log.info(contentContext.get("searchCricketMatchCountry"));
        Log4j.log.info(contentContext.get("cricketMatchTitles"));
        Log4j.log.info(contentContext.get("oneDayinternationalTourCricket"));
        Log4j.log.info(contentContext.get("twenty20internationalTourCricket"));
        Log4j.log.info(contentContext.get("searchCricketMatchCountryInValidText"));
        Log4j.log.info(contentContext.get("searchInvalidTextValidation"));
    }
}
