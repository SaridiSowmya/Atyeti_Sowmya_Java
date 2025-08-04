package com.example.CSVfileImporterandValidator.service;

import com.example.CSVfileImporterandValidator.model.User;
import com.example.CSVfileImporterandValidator.repository.UserRepository;
import com.example.CSVfileImporterandValidator.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CsvProcessingService {

    private final UserRepository userRepository;

    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public Map<String, Object> processCsv(MultipartFile file) throws IOException {
        List<String> errorLines = new ArrayList<>();
        List<User> validUsers = Collections.synchronizedList(new ArrayList<>());

        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        int lineNumber = 0;
        reader.readLine();
        lineNumber++;

        while ((line = reader.readLine()) != null) {
            final String currentLine = line;
            final int currentLineNumber = lineNumber++;

            executor.submit(() -> {
                String[] parts = currentLine.split(",");
                if (parts.length == 3 && UserValidator.isValid(parts[0], parts[1], parts[2])) {
                    User user = new User(0, parts[0], parts[1], Integer.parseInt(parts[2]));
                    validUsers.add(user);
                } else {
                    synchronized (errorLines) {
                        errorLines.add("Line " + currentLineNumber + ": " + currentLine);
                    }
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException("Processing interrupted", e);
        }

        userRepository.saveAll(validUsers);
        File errorFile = new File("C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Downloads\\CSVfileImporterandValidator\\CSVfileImporterandValidator\\src\\main\\resources\\invalid_rows.csv");
        try (FileWriter writer = new FileWriter(errorFile)) {
            for (String error : errorLines) {
                writer.write(error + "\n");
            }
        }


        Map<String, Object> result = new HashMap<>();
        result.put("totalRows", lineNumber - 1);
        result.put("validRows", validUsers.size());
        result.put("invalidRows", errorLines.size());
        result.put("errorFile", errorFile.getAbsolutePath());

        return result;
    }
}
