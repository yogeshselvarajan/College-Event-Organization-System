package project.college.event.organizer.login;

import java.sql.*;

import java.sql.Statement;

public class CheckConnectionToDataBase {

        public static void main(String[] args) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "localhost");//Establishing connection
                System.out.println("Connected With the database successfully");
            } catch (SQLException e) {
                System.out.println("Error while connecting to the database");
            }
        }

    }