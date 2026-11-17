package com.automation.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    // Properties object stores key-value pairs from config.properties
    public static Properties prop;

    // Loads configuration file into memory
    public static void loadConfig() {

        try {
            // Reads the properties file from project location
            FileInputStream file =
                    new FileInputStream(
                            "src/test/resources/config.properties");

            prop = new Properties();

            // Loads all properties into the Properties object
            prop.load(file);

            file.close();

        } catch (Exception e) {

            // Prints error if configuration file is not found
            e.printStackTrace();
        }
    }

    // Returns the value associated with the given key
    public static String getProperty(String key) {

        return prop.getProperty(key);
    }
}