package model;

public record Trade(String buyOrderId, String sellOrderId,
                    double price, int quantity, long timestamp) {

}