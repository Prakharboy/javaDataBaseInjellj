package com.stackroute;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseTest {


    protected static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/";
        // Database name to access
        String dbName = "mysql";
        String dbUsername = "root";
        String dbPassword = "YOUR_PASSWORD_HERE";

        Class.forName(dbDriver);
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/" + dbName + "?user=" + dbUsername + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false");
        return con;
    }
}
