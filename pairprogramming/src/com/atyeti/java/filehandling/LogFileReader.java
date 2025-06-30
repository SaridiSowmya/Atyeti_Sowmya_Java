package com.atyeti.filehandling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LogFileReader {

    private static final Logger logger = Logger.getLogger(LogFileReader.class.getName());
    public static List<Thread> threads = new ArrayList<>();

    public static volatile int errorCount = 0;
    public static volatile int warnCount = 0;
    public static volatile int infoCount = 0;

    static String outputFile = "C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sowmya_Java\\pairprogramming\\src\\com\\atyeti\\duplicatefiles\\logOutputWriter";

    public static void readLogs(String directoryPath) throws FileNotFoundException, InterruptedException {

        File file = new File(directoryPath);

        if (!file.exists() || !file.isDirectory()) {
            logger.warning("Directory does not exist: " + directoryPath);
            return;
        }
        else {
            File[] files = file.listFiles((d, name) -> name.endsWith(".log")); // filter only .log files
            if (files == null || files.length == 0) {
                logger.warning("No log files found in directory: " + directoryPath);
                return;
            }
            else {
                for (File file1 : files) {
                    Thread thread = new Thread(() -> processLogFile(file1));
                    thread.start();
                    threads.add(thread);
                }
            }
        }
    }

    private static void processLogFile(File file) {
        logger.info("Thread "+Thread.currentThread().getName()+" reading file: " + file.getName());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                //logger.info(Thread.currentThread().getName());
                if (line.contains(" ERROR ")) errorCount++;
                else if (line.contains(" WARNING ")) warnCount++;
                else if (line.contains(" INFO ")) infoCount++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
