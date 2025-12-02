package service;
import model.Stock;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
public class StockLoggerService {

    private final Logger logger = Logger.getLogger(StockLoggerService.class.getName());

    public void generateLogFilesPerStock(List<Stock> stockList) {
        stockList.stream().collect(Collectors.groupingBy(Stock::getSymbol)).entrySet().forEach(entry -> {
            String symbol = entry.getKey();
            List<Stock> stocks = entry.getValue();
            Path filePath = Paths.get("C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sowmya_Java\\stockmarketfeedprocessor\\src\\main\\java\\stocksdataperstockoutput\\" + symbol + ".csv");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                writer.write("Timestamp,Symbol,Price,Volume");
                writer.newLine();
                for (Stock stock : stocks) {
                    writer.write(stock.getTimestamp() + "," + stock.getSymbol() + "," + stock.getPrice() + "," + stock.getVolume());
                    writer.newLine();
                }
                logger.info("File created and updated: " + filePath.getFileName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}