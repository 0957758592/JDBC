package com.jdbc;

import java.sql.*;

class ExecuteQuery {


    static void executeQueryApp(Statement statement, String query) throws SQLException {

        String queryHeader = query.substring(0, query.indexOf(" ")).toUpperCase();

        if (!queryHeader.equals("SELECT")) {
            System.out.println(statement.executeUpdate(query));
        } else {
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metadata = resultSet.getMetaData();
            System.out.println("===========" +metadata.getTableName(1).toUpperCase()+ "============");
            int columnCount = metadata.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metadata.getColumnName(i) + " | ");
            }

            System.out.println();

            System.out.println("\n----------------------");
            System.out.println();
            while (resultSet.next()) {
                String row = "";
                for (int i = 1; i <= columnCount; i++) {
                    row += resultSet.getString(i) + " | ";
                }
                System.out.println(row);
                System.out.println("----------------------");

            }

            resultSet.close();
        }

    }

}
