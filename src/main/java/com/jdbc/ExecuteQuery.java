package com.jdbc;

import java.sql.*;

class ExecuteQuery {

    static void executeQueryApp(Statement statement, String query) throws SQLException {

        String queryHeader = query.substring(0, query.indexOf(" ")).toUpperCase();

        if (!queryHeader.equals("SELECT")) {
            System.out.println(statement.executeUpdate(query));
        } else {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String age = resultSet.getString(3);
            String email = resultSet.getString(4);

            System.out.println("| "+id+" | " + name+" | " + age+" | " + email+" |");
            }
            resultSet.close();
        }

    }

}
