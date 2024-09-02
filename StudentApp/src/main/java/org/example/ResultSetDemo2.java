package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class ResultSetDemo2
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

        //create statement
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE
            );

            //create query
            String query ="select * from students";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
            {
               System.in.read();
               System.in.read();
                resultSet.refreshRow();
                System.out.println(resultSet.getInt(1)+"  " +
                        "  "+resultSet.getString(2)+"    "+resultSet.getString(3));
            }
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
