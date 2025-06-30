package com.atyeti.databaseconnection;

import com.atyeti.filehandling.LogFileReader;

import java.sql.*;

public class DataBaseConn {
    public static void database(String url, String username,String password) {
        Connection connection=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            String createTableQuery="create table if not exists logsDataBase(" + "id int auto_increment primary key, "+
                    "timestamp timestamp,"+ "error_count int,"+"warning_count int,"+
                     "info_count int)";

            statement.executeUpdate(createTableQuery);
            System.out.println("created table successfully");
            String insertQuery = "INSERT INTO logsDataBase (timestamp, error_count, warning_count, info_count) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                preparedStatement.setInt(2, LogFileReader.errorCount);
                preparedStatement.setInt(3, LogFileReader.warnCount);
                preparedStatement.setInt(4, LogFileReader.infoCount);

                preparedStatement.executeUpdate();
                System.out.println("Data inserted successfully.");

                System.out.println("Inserted Log Summary: ERROR=" + LogFileReader.errorCount +
                        ", WARNING=" + LogFileReader.warnCount +
                        ", INFO=" + LogFileReader.infoCount);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

