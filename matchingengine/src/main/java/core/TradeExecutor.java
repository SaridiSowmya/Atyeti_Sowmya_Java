package core;
import model.Order;
import model.Trade;
import model.TradeType;
import trading.CSVOrderLoader;

import java.util.ArrayList;
import java.util.List;

public class TradeExecutor {

    private final List<Trade> trades = new ArrayList<>();
    private final OrderMatchingEngine engine;

    public TradeExecutor(OrderMatchingEngine engine) {
        this.engine = engine;
    }

    public synchronized void execute(Order buyOrder, Order sellOrder, int quantity, double price) {

       //reduces the remaining quantity of both orders
        buyOrder.fill(quantity);
        sellOrder.fill(quantity);

        if (buyOrder.isFilled()) {
            CSVOrderLoader.fullyFilledBuy++;
        } else if (buyOrder.getRemainingQuantity() < buyOrder.getOriginalQuantity()) {
            CSVOrderLoader.partiallyFilledBuy++;
        }

        if (sellOrder.isFilled()) {
            CSVOrderLoader.fullyFilledSell++;
        } else if (sellOrder.getRemainingQuantity() < sellOrder.getOriginalQuantity()) {
            CSVOrderLoader.partiallyFilledSell++;
        }

        Trade trade = new Trade(buyOrder.getOrderId(), sellOrder.getOrderId(), price, quantity, System.currentTimeMillis());
        trades.add(trade);

        TradeType asset = buyOrder.getTradeType();
        String buyId  = trade.buyOrderId().length() > 25
                ? trade.buyOrderId().substring(0, 22) + "..."
                : trade.buyOrderId();
        String sellId = trade.sellOrderId().length() > 25
                ? trade.sellOrderId().substring(0, 22) + "..."
                : trade.sellOrderId();


        System.out.printf("TRADE [%s] %s ↔ %s | %,d @ %.6f (Notional: $%,.2f)%n",
                formatAsset(asset),      // ← SHOWS EQUITY / FOREX / CRYPTO
                buyId, sellId,
                quantity, price, price * quantity);


        if (buyOrder.getRemainingQuantity() > 0 && buyOrder.getRemainingQuantity() < buyOrder.getOriginalQuantity()) {
            System.out.printf("   → BUY  PARTIALLY_FILLED (%d/%d left)%n",
                    buyOrder.getRemainingQuantity(), buyOrder.getOriginalQuantity());
        }
        if (sellOrder.getRemainingQuantity() > 0 && sellOrder.getRemainingQuantity() < sellOrder.getOriginalQuantity()) {
            System.out.printf("   → SELL PARTIALLY_FILLED (%d/%d left)%n",
                    sellOrder.getRemainingQuantity(), sellOrder.getOriginalQuantity());
        }
    }


    private String formatAsset(TradeType type) {
        return switch (type) {
            case EQUITY -> "EQUITY ";
            case FOREX  -> "FOREX  ";
            case CRYPTO -> "CRYPTO ";
        };
    }

    public List<Trade> getTrades() {
        return new ArrayList<>(trades);
    }
}