package loader;

import model.StockRecord;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvLoader{
    private static final String stockdatapart1="src/main/resources/stockdatapart1";
    private static final String stockdatapart2="src/main/resources/stockdatapart2";
    private static final String REJECT_FILE = "src/main/resources/rejected_records.csv";

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Map to dynamically resolve symbols
    private final Map<String, String> regSymbolMap = new HashMap<>();

        public List<StockRecord> loadOrders() {
            List<StockRecord> records = new ArrayList<>();

            try {
                loadFile(stockdatapart1, records);
                loadFile(stockdatapart2, records);
            } catch (IOException e) {
                System.out.println("Error while loading files: " + e.getMessage());
            }

            return records;
        }

        public void loadFile(String filePath, List<StockRecord> records) throws IOException {
            System.out.println("Loading file: " + filePath);

            try (BufferedReader br = new BufferedReader(new FileReader(filePath));
                 BufferedWriter bw = new BufferedWriter(new FileWriter(REJECT_FILE, true))) {

                br.readLine(); // Skip header
                String line;

                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;

                    String[] parts = line.split(",", -1);
                    if (parts.length != 9) {
                        bw.write(line);
                        bw.newLine();
                        continue;
                    }

                    try {
                        String registrationNumber = parts[1].trim();
                        String symbol = parts[2].trim();

                        // Resolve symbol dynamically
                        if ("null".equalsIgnoreCase(symbol)) {
                            symbol = regSymbolMap.get(registrationNumber);
                            if (symbol == null) {
                                bw.write(line);
                                bw.newLine();
                                continue;
                            }
                        } else {
                            // store for future null resolution
                            regSymbolMap.put(registrationNumber, symbol);
                        }

                        StockRecord record = new StockRecord(
                                Integer.parseInt(parts[0].trim()), // recordId
                                registrationNumber,
                                symbol,
                                LocalDate.parse(parts[3].trim(), DATE_FORMAT),
                                Double.parseDouble(parts[4].trim()), // open
                                Double.parseDouble(parts[5].trim()), // close
                                Double.parseDouble(parts[6].trim()), // high
                                Double.parseDouble(parts[7].trim()), // low
                                Long.parseLong(parts[8].trim())      // volume
                        );

                        records.add(record);

                    } catch (Exception e) {
                        bw.write(line);
                        bw.newLine();
                    }
                }

            } catch (Exception e) {
                System.out.println("Error while reading file " + filePath + ": " + e.getMessage());
            }
        }
}

