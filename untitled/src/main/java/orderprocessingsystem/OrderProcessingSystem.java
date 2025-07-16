package orderprocessingsystem;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderProcessingSystem{

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("sowmya", LocalDate.of(2024, 3, 1), 250.0),
                new Order("seetha", LocalDate.of(2024, 3, 2), 100.0),
                new Order("rekha", LocalDate.of(2024, 3, 5), 300.0),
                new Order("david", LocalDate.of(2024, 3, 6), 400.0),
                new Order("Bob", LocalDate.of(2024, 3, 8), 200.0),
                new Order("David", LocalDate.of(2024, 3, 9), 700.0),
                new Order("charlie", LocalDate.of(2024, 3, 10), 150.0),
                new Order("Charlie", LocalDate.of(2024, 3, 11), 100.0),
                new Order("David", LocalDate.of(2024, 3, 12), 350.0)
        );


        Map<String, Double> totalPerCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        Collectors.summingDouble(Order::getAmount)
                ));

        System.out.println("=== Total Order Value Per Customer ===");
        totalPerCustomer.forEach((customer, total) ->
                System.out.printf("%-10s -> $%.2f%n", customer, total));


        List<Map.Entry<String, Double>> top3Customers = totalPerCustomer.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("\n=== Top 3 Customers ===");
        top3Customers.forEach(entry ->
                System.out.printf("%-10s -> $%.2f%n", entry.getKey(), entry.getValue()));
    }
}



