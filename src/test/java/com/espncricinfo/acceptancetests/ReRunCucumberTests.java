package com.espncricinfo.acceptancetests;

import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.FILTER_TAGS_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("target/failedScenarios.txt")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.espncricinfo")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value = "src/test/resources/features")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, json:target/cucumber-reports/reports.json, json:target/cucumber-reports/cucumber.runtime.formatter.JSONFormatter")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME,value = "@demo1")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
public class ReRunCucumberTests {
}