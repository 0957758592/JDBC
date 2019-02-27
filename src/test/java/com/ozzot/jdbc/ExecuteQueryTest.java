package com.ozzot.jdbc;

import com.ozzot.jdbc.printer.DBTablePrinter;
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

    private static final String URL = "jdbc:mysql://localhost:3306/testDB?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234567890QQQ";

    private static final String CREATE = "CREATE TABLE IF NOT EXISTS users (id int AUTO_INCREMENT PRIMARY KEY ,name varchar(50), age int(3), email varchar(50));";
    private static final String INSERT = "insert into users (name, age, email) values ('Name', 123, '123@123.123');";
    private static final String UPDATE = "UPDATE users SET name = 'Alfred Schmidt', age = 555, email = '555@555.555' WHERE name = 'Name';";
    private static final String INSERT_BEFORE_DELETE = "insert into users (name, age, email) values ('Alfred Schmidt', 123, '123@123.123');";
    private static final String DELETE = "DELETE FROM users WHERE name = 'Alfred Schmidt';";
    private static final String DROP = "DROP TABLE users;";
    private static final String SELECT = "SELECT * FROM users;";

    private static final String MOCK_PRINT_TABLE =
            "Printing 2 rows from table users\n" +
                    "+----+------+-----+-------------+\n" +
                    "| id | name | age |    email    |\n" +
                    "+----+------+-----+-------------+\n" +
                    "|  1 | Name | 123 | 123@123.123 |\n" +
                    "+----+------+-----+-------------+\n" +
                    "|  2 | Name | 123 | 123@123.123 |\n" +
                    "+----+------+-----+-------------+\n" +
                    "\n";

    private Connection connection;
    private Statement statement;

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
    }

    @Test
    public void executeQueryApp() throws SQLException {
        assertEquals(0, statement.executeUpdate(CREATE));
//        assertEquals("Table 'USERS' have been created", outContent.toString()); <-- doesn't print in try catch
        assertEquals(1, statement.executeUpdate(INSERT));
        assertEquals(1, statement.executeUpdate(UPDATE));

        //prepare delete
        statement.executeUpdate(INSERT_BEFORE_DELETE);
        statement.executeUpdate(INSERT_BEFORE_DELETE);
        //then delete
        assertEquals(3, statement.executeUpdate(DELETE));


        // prepare drop
        assertEquals(0, statement.executeUpdate(DROP));
        // then drop
//        assertEquals("Table 'USERS' have been removed", outContent.toString()); <-- doesn't print in try catch

        //prepare select
        statement.executeUpdate(CREATE);
        statement.executeUpdate(INSERT);
        statement.executeUpdate(INSERT);
        ResultSet resultSet = statement.executeQuery(SELECT);
        DBTablePrinter.printResultSet(resultSet);
        //then select
        assertEquals(MOCK_PRINT_TABLE, outContent.toString());

        // prepare drop
        assertEquals(0, statement.executeUpdate(DROP));
        // then drop
//        assertEquals("Table 'USERS' have been removed", outContent.toString()); <-- doesn't print in try catch
    }
}