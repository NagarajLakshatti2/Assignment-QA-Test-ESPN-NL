package com.espncricinfo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class JsonLoadData {

    private static final ClassLoader classLoader = JsonLoadData.class.getClassLoader();

    private static HashMap getJsonFileAsMap(String fileLocation) {

        try {
            return new ObjectMapper().readValue(getTestFile(fileLocation), HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON file to a Map", e);
        }
    }

    public static URL getTestFile(String fileLocation) {

        return classLoader.getResource(fileLocation);
    }
}
