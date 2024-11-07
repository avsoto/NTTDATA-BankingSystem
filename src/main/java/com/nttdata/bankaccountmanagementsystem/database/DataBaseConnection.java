package com.nttdata.bankaccountmanagementsystem.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {

    /**
     * Establishes and returns a Connection object to the database using the
     * configuration details from the 'database.properties' file.
     *
     * @return a Connection object if the connection is successful, or null
     *         if an exception occurs
     */
    public static Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/database.properties");
            properties.load(input);

            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            String driver = properties.getProperty("db.driver");

            Class.forName(driver);

            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
