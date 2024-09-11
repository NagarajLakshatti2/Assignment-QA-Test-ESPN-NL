package com.userprofiledata;

import com.espncricinfo.utils.KeyContext;
import com.espncricinfo.utils.Log4j;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ReadUserTestData {
    private final KeyContext  keyContext;
    private JsonNode jsonNode = null;

    public ReadUserTestData() {
        this.keyContext = new KeyContext();
    }

    public void setTestDataContext() throws IOException, URISyntaxException {

        File readFile = new File(System.getProperty("user.dir") + File.separator + "testdata" + File.separator + "seasonview.json");
        jsonNode = UserDataCollections.getFileFromResource(String.valueOf(readFile));

        keyContext.set("espncricinfo_url", jsonNode.get("espncricinfo_url").asText());
        keyContext.set("searchCricketMatchCountry", jsonNode.get("searchCricketMatchCountry").asText());
        keyContext.set("cricketMatchTitles", jsonNode.get("cricketMatchTitles").get("cricketMatchTitles").asText());
        keyContext.set("oneDayinternationalTourCricket", jsonNode.get("cricketMatchTitles").get("oneDayinternationalTourCricket").asText());
        keyContext.set("twenty20internationalTourCricket", jsonNode.get("cricketMatchTitles").get("twenty20internationalTourCricket").asText());
        keyContext.set("searchCricketMatchCountryInValidText", jsonNode.get("searchCricketMatchCountryInValidText").asText());

        keyContext.set("searchInvalidTextValidation", jsonNode.get("seasonView").get("searchInvalidTextValidation").asText());

        Log4j.log.info(keyContext.get("espncricinfo_url"));
        Log4j.log.info(keyContext.get("searchCricketMatchCountry"));
        Log4j.log.info(keyContext.get("cricketMatchTitles"));
        Log4j.log.info(keyContext.get("oneDayinternationalTourCricket"));
        Log4j.log.info(keyContext.get("twenty20internationalTourCricket"));
        Log4j.log.info(keyContext.get("searchCricketMatchCountryInValidText"));
        Log4j.log.info(keyContext.get("searchInvalidTextValidation"));
    }
}
