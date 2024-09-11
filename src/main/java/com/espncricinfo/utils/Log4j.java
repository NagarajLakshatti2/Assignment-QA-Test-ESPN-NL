package com.espncricinfo.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log4j {
    public static Logger log;

    public Log4j() {
        FileHandler fh;
        log = Logger.getLogger(Log4j.class.getName());
        try {
            File readFile = new File(System.getProperty("user.dir") + File.separator + "logger" + File.separator + "logfile.log");
            System.out.println(readFile.getPath());
            // This block configure the logger with handler and formatter
            fh = new FileHandler(readFile.getPath());
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            // the following statement is used to log any messages
            log.info("============================ Logger Start =========================");
        } catch (SecurityException | IOException e) {
            e.getStackTrace();
        }
    }
}
