package loganalyzerandreportgenerator.logdata;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {

    public static void createData(Connection conn)
    {

        String createTableSQL = "CREATE TABLE if not exists logsData11 ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "timestamp TIMESTAMP,"
                + "error_count INT,"
                + "warning_count INT,"
                + "info_count INT"
                + ")";

        try (Statement statement = conn.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table logsData1 created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }
}
