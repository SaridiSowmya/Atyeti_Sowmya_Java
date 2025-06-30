package loganalyzerandreportgenerator.reader;

import java.io.*;

public class OutputFile {
    public static void main(String[] args) {

        String folderPath = "C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Sowmya\\Sampleconnection\\resources";
        String outputFilePath = folderPath + "\\output.log";

        File folder = new File(folderPath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && !file.getName().equals("output.log")) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                writer.write(line);
                                writer.newLine();
                            }
                        }
                    }
                }
                System.out.println("Data successfully added into the output file: " + outputFilePath);
            } else {
                System.out.println("No files found in the folder.");
            }
        } catch (IOException e) {
            System.err.println("Error in output file.");
            e.printStackTrace();
        }

    }
}
