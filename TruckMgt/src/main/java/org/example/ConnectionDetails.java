package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDetails {
    //public static final String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String  URL="jdbc:mysql://localhost:3306/truckmgt";
    public static final String  PASSWORD="root";
    public static final String  USERNAME="root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

}
