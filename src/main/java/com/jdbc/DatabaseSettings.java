package com.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

final class DatabaseSettings {

    static String[] getDatabaseSettings(String db_properties) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(db_properties);
        Properties properties = new Properties();
        properties.load(fileInputStream);

        final String JDBC_TYPE = properties.getProperty("JDBC_TYPE");
        final String URL = properties.getProperty("URL");
        final String PORT = properties.getProperty("PORT");
        final String DBNAME = properties.getProperty("DBNAME");
        final String DBSETTINGS = properties.getProperty("DBSETTINGS");
        final String USERNAME = properties.getProperty("USERNAME");
        final String PASSWORD = properties.getProperty("PASSWORD");

        return new String[]{JDBC_TYPE + URL + PORT + DBNAME + DBSETTINGS, USERNAME, PASSWORD};
    }
}
