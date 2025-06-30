package loganalyzerandreportgenerator.reader;

import java.io.*;
import java.util.logging.Logger;

public class LogFileReader {

    private static final Logger logger = Logger.getLogger(LogFileReader.class.getName());

    public static void main(String[] args) throws FileNotFoundException {
        //String filePath = "C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Sowmya\\Sampleconnection\\resources";

        String folderPath = "C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Sowmya\\Sampleconnection\\resources";


        File folder = new File(folderPath);

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files)

                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        System.err.println("Error reading file: " + file.getName());
                        e.printStackTrace();
                    }


            }
        }
    }
}




















