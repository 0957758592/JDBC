package com.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryApp {
    public static void main(String[] args) throws IOException, SQLException {

        String dbSettingsPathName = args[0];

        try (Connection connection = new CreateConnection().getProperties(dbSettingsPathName);
             Statement statement = connection.createStatement();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("----------------------------------");
                System.out.println("Enter SQL Query or 'Q' to Escape: ");
                System.out.println("----------------------------------");

                String query = bufferedReader.readLine();

                if (query.equals("Q")) {
                    System.out.println("Exit!");
                    System.exit(0);
                }
                ExecuteQuery.executeQueryApp(statement, query);
            }
        }
    }

}
