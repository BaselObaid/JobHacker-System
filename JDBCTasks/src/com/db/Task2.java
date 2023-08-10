package com.db;

  /*
    * register to mysql
    * create the connection with the database
    * create the statement
    * method to create table
    * method to insert rows
    * method to update column data
    * method to rename column name
  */

import java.sql.*;

public class Task2 {

    public static void main (String [] args){

        Task1.registerMysqlDB();

        String url = "jdbc:mysql://localhost:3306/task";
        String username = "userName";
        String password = "password";
        Connection connection = Task1.createConnection(url, username, password);
        Statement statement = Task1.createStatement(connection);

        String tableName = "Employee";

        // 1-
        createTable(statement,tableName,"id int", "F_Name varchar(20)",
                "L_Name varchar(20)", "Sex Enum('male', 'female')", "Age int CHECK (age >= 18 AND age <= 70)",
                "Address varchar(70)", "Phone_Number varchar(20)",
                "Vacation_Balance int default 30");

        insertDataIntoRow(connection,tableName,1,"basel","obaid","male",22,"Cairo","010",10);
        insertDataIntoRow(connection,tableName,2,"mohamed","ahmed","male",23,"Cairo","010",30);
        insertDataIntoRow(connection,tableName,3,"karim","adil","male",23,"Cairo","010",30);
        insertDataIntoRow(connection,tableName,4,"khaled","ibrahim","male",22,"Cairo","010",30);
        insertDataIntoRow(connection,tableName,5,"Mona","ahmed","female",30,"Cairo","010",40);
        insertDataIntoRow(connection,tableName,6,"alaa","ibrahim","female",50,"Cairo","010",30);

        // 2-
        updateVacationBalanceByAge(statement,tableName,45,45);

        renameColumn(statement,tableName,"F_Name","Mr/Mrs");


    }


    public static void createTable(Statement statement, String tableName, String... columnsWithType) {
        String allColumns = String.join(", ", columnsWithType);
        String createTableSQL = "CREATE TABLE " + tableName + " (" + allColumns + ")";

        try {
            statement.execute(createTableSQL);
            System.out.println("Table created successfully: " + tableName);
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        }
    }

    public static void insertDataIntoRow(Connection connection, String tableName, Object... values) {
        String placeholders = "";
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                placeholders += ", ";
            }
            placeholders += "?";
        }
        String insertSQL = "INSERT INTO " + tableName + " VALUES (" + placeholders + ")";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }
            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully into: " + tableName);
        } catch (SQLException sqlException) {
            System.err.println("Error inserting data: " + sqlException);
        }
    }

    public static void updateVacationBalanceByAge(Statement statement,String tableName, int newVacationBalance, int age){
        String query = "UPDATE " + tableName
                        + " SET Vacation_Balance = " + newVacationBalance
                        + " WHERE Age >= " + age;
        try {
            statement.addBatch(query);
            statement.executeBatch();
            System.out.println("Data updated successfully");
        }catch (SQLException sqlException){
            System.err.println("Error updating data: " + sqlException);
        }
    }

    public static void renameColumn(Statement statement, String tableName, String currentName, String newName){
        String query = "ALTER TABLE " + tableName
                        + " RENAME COLUMN " + currentName + " TO " + "`"+newName+"`";
        try{
            statement.addBatch(query);
            statement.executeBatch();
            System.out.println(currentName + " is updated successfully to "+ newName);
        }catch (SQLException sqlException){
            System.err.println(sqlException);
        }
    }

}


