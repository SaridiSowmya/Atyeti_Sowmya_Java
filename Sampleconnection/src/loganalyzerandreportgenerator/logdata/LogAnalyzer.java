package loganalyzerandreportgenerator.logdata;
import java.sql.Connection;
import java.sql.DriverManager;


public class LogAnalyzer {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/logfilesData1";
        String user = "root";
        String password = "sowmya";
        Connection connection = null;

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            Data.createData(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}






























//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
//            Connection conn = DriverManager.getConnection(url, user, password);
        //System.out.println("Connected to the database successfully!");

//            String createTableSQL = "CREATE TABLE logsData1 ("
//                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
//                    + "timestamp TIMESTAMP,"
//                    + "error_count INT,"
//                    + "warning_count INT,"
//                    + "info_count INT"
//                    + ")";
//
//            Statement statement=conn.createStatement();
//            statement.execute(createTableSQL);
//            System.out.println("Table created successfully.");

        // Close the connection
//            conn.close();
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


//
// }
