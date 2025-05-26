package loganalyzerandreportgenerator.logdata;
import java.io.*;
import java.sql.*;
import java.util.logging.Logger;

public class DataCounter {
    private static final Logger logger = Logger.getLogger(DataCounter.class.getName());
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Sowmya\\Sampleconnection\\resources";
        int errorCount = 0;
        int warnCount = 0;
        int infoCount = 0;
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (line.contains(" ERROR ")) errorCount++;
                            if (line.contains(" WARNING ")) warnCount++;
                            if (line.contains(" INFO ")) infoCount++;
                        }
                    } catch (IOException e) {
                                logger.severe("Error reading file: " + file.getName());

                    }

                }
            }
        }

        System.out.println("ERROR: " + errorCount + ", WARN: " + warnCount + ", INFO: " + infoCount);

        Timestamp now = new Timestamp(System.currentTimeMillis());
        insertIntoDatabase(now, errorCount, warnCount, infoCount);

    }

    private static void insertIntoDatabase(Timestamp timestamp,int error, int warn, int info) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/logfilesData1";
        String username = "root";
        String password = "sowmya";

        String createTableSQL = "CREATE TABLE if not exists logsData11 ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "timestamp TIMESTAMP,"
                + "error_count INT,"
                + "warning_count INT,"
                + "info_count INT"
                + ")";

        String insertSQL = "INSERT INTO logsData11 (timestamp,error_count, warning_count, info_count) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTableSQL);


            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                Timestamp now = new Timestamp(System.currentTimeMillis());
                pstmt.setTimestamp(1,now);
                pstmt.setInt(2, error);
                pstmt.setInt(3, warn);
                pstmt.setInt(4, info);
                pstmt.executeUpdate();
                System.out.println("Log counts inserted into database.");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}


