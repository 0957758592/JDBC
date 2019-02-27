package com.ozzot.jdbc;

import com.ozzot.jdbc.service.ExecuteQuery;
import com.ozzot.jdbc.utils.ConnectionCreator;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

public class QueryApp {
    private static final String DB_PROPERTIES = System.getProperty("properties.location");

    public static void main(String[] args) throws IOException, SQLException {

        isDbPropertiesNotNull();

        try (Connection connection = ConnectionCreator.getConnection(DB_PROPERTIES);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.println("+-----------------------------------+");
                System.out.println("| Enter SQL Query or 'Q' to Escape: |");
                System.out.println("+-----------------------------------+");

                String query = bufferedReader.readLine();

                if (query.equals("Q")) {
                    System.out.println("Exit!");
                    System.exit(0);
                }

                ExecuteQuery.executeQueryApp(connection, query);
            }
        }
    }

    private static void isDbPropertiesNotNull() {

        if (DB_PROPERTIES == null) {
            throw new IllegalArgumentException(DB_PROPERTIES + " is undefined");
        }
    }

}
