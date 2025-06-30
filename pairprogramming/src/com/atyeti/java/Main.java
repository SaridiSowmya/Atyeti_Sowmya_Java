package com.atyeti;

import com.atyeti.databaseconnection.DataBaseConn;
import com.atyeti.filehandling.LogFileReader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        String directoryPath="C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sowmya_Java\\pairprogramming\\src\\com\\atyeti\\logfiles";
        LogFileReader.readLogs(directoryPath);
        for (Thread thread :LogFileReader.threads) {
            thread.join();
        }
        DataBaseConn.database("jdbc:mysql://localhost:3306/logsdata","root","sowmya");
    }
}
