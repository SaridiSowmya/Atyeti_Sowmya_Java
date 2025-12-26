package trading;
import Interface.MatchingEngine;
import core.OrderMatchingEngine;
import exception.*;
import model.Order;
import model.OrderType;
import model.TradeType;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;


public class CSVOrderLoader {

    private static final Logger log = Logger.getLogger(CSVOrderLoader.class.getName());
    private static final String BUY_ORDERS_PATH ="src/main/resources/buy_orders.csv";//"C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sowmya_Java\\matchingengine\\src\\main\\resources\\buy_orders.csv";
    private static final String SELL_ORDERS_PATH ="src/main/resources/sell_orders.csv";//"C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sowmya_Java\\matchingengine\\src\\main\\resources\\sell_orders.csv";
    public static long buySubmitted = 0;
    public static long buyRejected = 0;
    public static long sellSubmitted = 0;
    public static long sellRejected = 0;


    public static long fullyFilledBuy = 0;
    public static long fullyFilledSell = 0;
    public static long partiallyFilledBuy = 0;
    public static long partiallyFilledSell = 0;
    private static final DateTimeFormatter TS_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void loadOrders(MatchingEngine engine) {
       loadFile(BUY_ORDERS_PATH, engine, OrderType.BUY);
        loadFile(SELL_ORDERS_PATH, engine, OrderType.SELL);
    }

    private static void loadFile(String filePath, MatchingEngine engine, OrderType expectedType) {
        System.out.println("\nLoading " + expectedType + " orders from: " + filePath);
        System.out.println("-".repeat(70));
        long submitted = 0;
        long rejected = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

        br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                try {
                    String[] parts = line.split(",", -1);
                    if (parts.length != 8) {
                        rejected++;
                        continue;
                    }
                    Order order = new Order(
                            parts[0].trim(),
                            parts[1].trim(),
                            TradeType.valueOf(parts[2].trim()),
                            OrderType.valueOf(parts[3].trim()),
                            Double.parseDouble(parts[4].trim()),
                            Integer.parseInt(parts[5].trim()),
                            parts[6].trim(),
                            LocalDateTime.parse(parts[7].trim(), TS_FORMAT)
                    );
                    if (order.getOrderType() != expectedType) {
                        rejected++;
                        continue;
                    }
                    engine.submitOrder(order);
                    submitted++;

                } catch (DuplicateOrderIdException e) {
                    rejected++;
                    //System.out.println("REJECTED Duplicate ID: " + e.getMessage());
                    log.info("REJECTED Duplicate ID: " + e.getMessage());
                } catch (InvalidCountryException e) {
                    rejected++;
                    log.info("REJECTED Country: " + e.getMessage());
                } catch (AmountLimitExceededException e) {
                    rejected++;
                    log.info("REJECTED Amount Limit: " + e.getMessage());
                } catch (InvalidOrderException e) {
                    rejected++;
                    log.info("REJECTED Invalid Data: " + e.getMessage());
                } catch (Exception e) {
                    rejected++;
                    log.info("REJECTED Parse Error: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            //System.err.println("Failed to read file: " + filePath + " → " + e.getMessage());
           log.warning("Failed to read file: " + filePath + " → " + e.getMessage());
        }

        if (expectedType == OrderType.BUY) {
            buySubmitted = submitted;
            buyRejected = rejected;
        } else {
            sellSubmitted = submitted;
            sellRejected = rejected;
        }
//     System.out.printf("\n%s → Submitted: %,d | Rejected: %,d%n",
//            expectedType, submitted, rejected);
//        //log.info("\n%s → Submitted: %,d | Rejected: %,d%n",expectedType,submitted,rejected);
//        System.out.println("-".repeat(70));

    }
}