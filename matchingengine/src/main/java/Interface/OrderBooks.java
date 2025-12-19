package Interface;
import model.Order;

public interface OrderBooks {
    void addOrder(Order order);
    Order peekBestBuy();
    Order peekBestSell();
    Order pollBestBuy();
    Order pollBestSell();
}
