package com.atyeti.databaseconnection;

import com.atyeti.filehandling.LogFileReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class DataBaseConnTest {

    static String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"; // in-memory
    static String username = "sa";
    static String password = "";

    @BeforeEach
    void setupCounters() {
        // Simulate log counters
        LogFileReader.errorCount = 2;
        LogFileReader.warnCount = 1;
        LogFileReader.infoCount = 3;
    }

    @Test
    void testDatabaseMethodCreatesTableAndInsertsData() throws SQLException {
        // Call the actual method with H2
        DataBaseConn.database(url, username, password);

        // Verify data inserted
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM logsDataBase")) {

            assertTrue(rs.next()); // At least one row inserted
            assertEquals(2, rs.getInt("error_count"));
            assertEquals(1, rs.getInt("warning_count"));
            assertEquals(3, rs.getInt("info_count"));
        }
    }
}
