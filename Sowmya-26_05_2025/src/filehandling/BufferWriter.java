package filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriter {

    BufferedWriter bufferedWriter = null;
    try {
        bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/bufferedoutput.txt"));
        try {
            bufferedWriter.write("Hello, this is a buffered write example!");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        bufferedWriter.newLine();  // Write a new line
        bufferedWriter.write("This is the second line.");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

