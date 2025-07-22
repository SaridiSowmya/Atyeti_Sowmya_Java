package ecommerceplatform.util;
import java.io.*;
import java.util.*;

public class CSVUtil {
    public static List<String[]> read(String filePath) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }
        } catch (IOException e) {
            System.out.println(" Error reading file: " + filePath + " - " + e.getMessage());
        }
        return records;
    }


    public static void write(String filePath, String[] row) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(String.join(",", row));
            bw.newLine();
        } catch (IOException e) {
            System.out.println(" Error writing to file: " + filePath + " - " + e.getMessage());
        }
    }

    public static void overwrite(String filePath, List<String[]> rows) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : rows) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(" Error overwriting file: " + filePath + " - " + e.getMessage());
        }
    }
}



