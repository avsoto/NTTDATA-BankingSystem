package com.nttdata.bankaccountmanagementsystem.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {

    public static Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try {
            // Cargar el archivo de propiedades
            FileInputStream input = new FileInputStream("src/database.properties");
            properties.load(input);

            // Obtener propiedades de conexión
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            String driver = properties.getProperty("db.driver");

            // Cargar el driver
            Class.forName(driver);

            // Establecer la conexión
            connection = DriverManager.getConnection(url, user, password);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
