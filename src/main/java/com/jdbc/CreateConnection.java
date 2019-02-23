package com.jdbc;

import java.io.IOException;
import java.sql.*;

class CreateConnection {

    Connection getProperties(String dbSettingsPathName) throws IOException, SQLException {
        String[] settings = DatabaseSettings.getDatabaseSettings(dbSettingsPathName);
        String url = settings[0];
        String username = settings[1];
        String password = settings[2];

        return DriverManager.getConnection(url, username, password);
    }
}
