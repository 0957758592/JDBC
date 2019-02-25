package com.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.*;

import static org.junit.Assert.*;

public class ExecuteQueryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    static final String URL = "jdbc:mysql://localhost:3306/testDB?autoReconnect=true&useSSL=false";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234567890QQQ";

    static final String CREATE = "CREATE TABLE IF NOT EXISTS users (id int AUTO_INCREMENT PRIMARY KEY ,name varchar(50), age int(3), email varchar(50));";
    static final String INSERT = "insert into users (name, age, email) values ('Name', 123, '123@123.123');";
    static final String UPDATE = "UPDATE users SET name = 'Alfred Schmidt', age = 555, email = '555@555.555' WHERE name = 'Name';";
    static final String DELETE = "DELETE FROM users WHERE name = 'Alfred Schmidt';";
    static final String DROP = "DROP TABLE users;";
    static final String SELECT = "SELECT * FROM users;";

    static final String MOCK_PRINT_TABLE = "Printing 2 rows from table users\n" +
                                            "+----+------+-----+-------------+\n" +
                                            "| id | name | age |    email    |\n" +
                                            "+----+------+-----+-------------+\n" +
                                            "|  1 | Name | 123 | 123@123.123 |\n" +
                                            "+----+------+-----+-------------+\n" +
                                            "|  2 | Name | 123 | 123@123.123 |\n" +
                                            "+----+------+-----+-------------+\n" +
                                            "\n";

    Connection connection;
    Statement statement;

    @Before
    public void before() throws SQLException {
        System.setOut(new PrintStream(outContent));
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        statement = connection.createStatement();
    }

    @After
    public void after() throws SQLException {
        System.setOut(originalOut);
        connection.close();
        statement.close();
    }

    @Test
    public void executeQueryApp() throws SQLException {
        assertEquals(0, statement.executeUpdate(CREATE));
        assertEquals(1, statement.executeUpdate(INSERT));
        assertEquals(1, statement.executeUpdate(UPDATE));
        assertEquals(1, statement.executeUpdate(DELETE));

        assertEquals(0, statement.executeUpdate(DROP));

        //prepare
        statement.executeUpdate(CREATE);
        statement.executeUpdate(INSERT);
        statement.executeUpdate(INSERT);
        ResultSet resultSet = statement.executeQuery(SELECT);
        DBTablePrinter.printResultSet(resultSet);

        //then
        assertEquals(MOCK_PRINT_TABLE, outContent.toString());
        assertEquals(0, statement.executeUpdate(DROP));
    }
}