package output;

import model.StockRecord;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class JsonWriter {

    private static final String OUTPUT =
            "src/main/resources/final_output.json";

    public void write(List<StockRecord> records) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT))) {

            bw.write("[\n");

            for (int i = 0; i < records.size(); i++) {
                StockRecord r = records.get(i);

                bw.write("  {\n");
                bw.write("    \"recordId\": " + r.getRecordId() + ",\n");
                bw.write("    \"registrationNumber\": \"" + r.getRegistrationNumber() + "\",\n");
                bw.write("    \"symbol\": \"" + r.getSymbol() + "\",\n");
                bw.write("    \"date\": \"" + r.getDate() + "\",\n");
                bw.write("    \"open\": " + r.getOpen() + ",\n");
                bw.write("    \"close\": " + r.getClose() + ",\n");
                bw.write("    \"high\": " + r.getHigh() + ",\n");
                bw.write("    \"low\": " + r.getLow() + ",\n");
                bw.write("    \"volume\": " + r.getVolume() + ",\n");
                bw.write("    \"isUpdated\": " + r.getIsUpdated() + "\n");
                bw.write("  }");

                if (i < records.size() - 1) bw.write(",");
                bw.write("\n");
            }

            bw.write("]");

        } catch (Exception e) {
            System.out.println("JSON errors: " + e.getMessage());
        }
    }
}
