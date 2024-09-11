package com.espncricinfo.globalparameters;

import com.espncricinfo.utils.Log4j;

public class GlobalParameters {
    public GlobalParameters(){
    }

    private static String browserName = new String();
//    private static ThreadLocal<String> testGroupTag = new ThreadLocal<String>();

    public void setBrowserName(String browser) {
        browserName = browser;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void initializeGlobalParams() {
        GlobalParameters globalParams = new GlobalParameters();
        globalParams.setBrowserName(System.getProperty("browserName", "chrome"));
        Log4j.log.info("Browser init: "+getBrowserName());
    }
}
