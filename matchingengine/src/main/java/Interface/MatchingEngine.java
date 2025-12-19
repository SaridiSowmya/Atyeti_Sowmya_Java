package Interface;
import model.Order;
import model.Trade;
import java.util.List;

public interface MatchingEngine {
    void submitOrder(Order order);
    List<Trade> getTrades();
    void shutdown();
}