package com.ozzot.jdbc.utils;

import java.io.IOException;
import java.sql.*;

public class ConnectionCreator {

    public static Connection getConnection(String dbSettingsPathName) throws IOException, SQLException {
        String[] settings = DatabaseSettings.getDatabaseSettings(dbSettingsPathName);
        String url = settings[0];
        String username = settings[1];
        String password = settings[2];
        return DriverManager.getConnection(url, username, password);
    }
}
