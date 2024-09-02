package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class PrepareStmtDemo
{
    public static String  LOAD_DRIVER="com.mysql.cj.jdbc.Driver";
    public static String  URL="jdbc:mysql://localhost:3306/studentdb";
    public static String  PASSWORD="root";
    public static String  USERNAME="root";
    public static void main( String[] args )
    {
        try {
            //load driver
            Class.forName(LOAD_DRIVER);

            //making connection
        Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);

        /*String query ="delete from students where  id = ?";
        //create statement
         PreparedStatement prepareStatement = connection.prepareStatement(query);
         prepareStatement.setInt(1,4);

         int rowImpacted = prepareStatement.executeUpdate();
         System.out.println(rowImpacted);*/

         String insertQuery = "insert into students (id,name,course) values (?,?,?)";
         PreparedStatement prepareStatement = connection.prepareStatement(insertQuery);

         prepareStatement.setInt(1,4);
         prepareStatement.setString(2,"Amit");
         prepareStatement.setString(3,"DevOps");

            int update = prepareStatement.executeUpdate();
            System.out.println("row impacted : "+update);

            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
