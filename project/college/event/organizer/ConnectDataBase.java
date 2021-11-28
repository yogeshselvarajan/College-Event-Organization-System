package project.college.event.organizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDataBase {
    public static Connection connectdb() throws SQLException
    {
        Connection con = null;
        try
        {
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","localhost");
            return con;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}