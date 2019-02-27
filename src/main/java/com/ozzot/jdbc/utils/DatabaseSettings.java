package com.ozzot.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseSettings {

    public static String[] getDatabaseSettings(String dbProperties) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(dbProperties);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        final String URL = properties.getProperty("jdbc.url");
        final String USERNAME = properties.getProperty("jdbc.username");
        final String PASSWORD = properties.getProperty("jdbc.password");

        return new String[]{URL, USERNAME, PASSWORD};
    }
}
