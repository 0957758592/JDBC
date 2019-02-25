package com.jdbc;

import java.sql.*;

class ExecuteQuery {


    static void executeQueryApp(Connection connection, Statement statement, String query) throws SQLException {

        String queryHeader = query.substring(0, query.indexOf(" ")).toUpperCase();

        if (!queryHeader.equals("SELECT")) {
            System.out.println(statement.executeUpdate(query));
        } else {
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metadata = resultSet.getMetaData();

            DBTablePrinter.printTable(connection, metadata.getTableName(1));
            resultSet.close();
        }
    }
}
