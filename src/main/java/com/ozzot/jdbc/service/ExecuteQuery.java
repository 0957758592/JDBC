package com.ozzot.jdbc.service;

import com.ozzot.jdbc.printer.DBTablePrinter;

import java.sql.*;

public class ExecuteQuery {

    public static void executeQueryApp(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();

        String queryHeader = query.substring(0, query.indexOf(" ")).toUpperCase();
        String queryTableName = query.contains("EXISTS") || query.contains("exists") ? query.split(" ")[5].toUpperCase() : query.split(" ")[2].toUpperCase();

        if (!queryHeader.equals("SELECT")) {

            if (queryHeader.equals("CREATE")) {
                createOrDropTable(statement, query, queryTableName, true);
            } else if (queryHeader.equals("DROP")) {
                createOrDropTable(statement, query, queryTableName.replace(";", ""), false);
            } else {
                System.out.println(statement.executeUpdate(query));
            }

        } else {
            ResultSet resultSet = statement.executeQuery(query);

            DBTablePrinter.printResultSet(resultSet);
            resultSet.close();
        }

        statement.close();
    }

    private static void createOrDropTable(Statement statement, String query, String queryTableName, boolean create) {

        String modifier = create ? "created" : "removed";

        try {
            statement.executeUpdate(query);
            System.out.println("Table '" + queryTableName + "' have been " + modifier);
        } catch (SQLException e) {

            String warning = create ?
                    "WARNING! Table: '" + queryTableName + "' already is exist" :
                    "WARNING! Unknown table: '" + queryTableName + "' Please, check TableName";

            System.err.println(warning);
        }
    }
}
