package com.db;

import java.sql.*;

public class Task1 {


    public static void main(String [] args) throws SQLException{


            registerMysqlDB();

            String url = "jdbc:mysql://localhost:3306/task";
            String username = "userName";
            String password = "password";

            Connection connection = createConnection(url, username, password);

            Statement statement = createStatement(connection);

            String query = "SELECT id, first_name, last_name FROM customers";
            ResultSet resultSet = makeQuery(statement, query);

            // print all data on the table
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName);
            }


            // Close resources
            closeAllResources(connection,statement,resultSet);


    }

    public static void registerMysqlDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("successful register");
        }catch (ClassNotFoundException ex){
            System.err.println(ex);
        }
    }

    public static Connection createConnection(String url, String userName, String dbPassword){
        try {
            Connection connection = DriverManager.getConnection(url, userName, dbPassword);
            System.out.println("successful connection");
            return connection;
        }catch (SQLException ex){
            System.err.println(ex);
            return null;
        }
    }

    public static Statement createStatement(Connection connection){
        try {
            Statement statement = connection.createStatement();
            return statement;
        }catch (SQLException ex){
            System.err.println(ex);
            return null;
        }
    }

    public static ResultSet makeQuery(Statement statement, String query ){
        try {
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        }catch (SQLException ex){
            System.err.println(ex);
            return null;
        }
    }



    public static void closeAllResources(Connection connection, Statement statement, ResultSet resultSet) throws SQLException{
        resultSet.close();
        statement.close();
        connection.close();
    }

}
