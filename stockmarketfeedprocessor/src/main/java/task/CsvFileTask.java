package task;
import model.Stock;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;


public class CsvFileTask extends RecursiveTask<List<Stock>> {

    private final File file;

    public CsvFileTask(File file) {
        this.file = file;
    }

    @Override
    protected List<Stock> compute() {

        List<Stock> stockList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            boolean skipHeader = true;
            while ((line = br.readLine()) != null) {

                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String[] parts = line.split(",");
                Timestamp timestamp = Timestamp.valueOf(parts[0].replace("T"," ").replace("Z"," "));
                String symbol = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());
                double volume = Double.parseDouble(parts[3].trim());

                Stock stock = new Stock(price, symbol, timestamp, volume);

                stockList.add(stock);
            }

            System.out.println(Thread.currentThread().getName() +
                    " processed file: " + file.getName() +
                    " | Records: " + stockList.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockList;
    }
}
