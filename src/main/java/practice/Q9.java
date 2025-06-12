package practice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q9 {
    //You have a list of Customer objects, each with a list of Orders.
    // How would you compute the total purchase amount for each customer and then sort the customers by that amount in descending order?
    public record Order(double purchaseAmount){};
    public record Customer(String customerName, List<Order> orders){};
    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer("Alice", List.of(new Order(250.0), new Order(100.0))),
                new Customer("Bob", List.of(new Order(80.0))),
                new Customer("Charlie", List.of(new Order(300.0), new Order( 200.0))),
                new Customer("Diana", List.of(new Order( 150.0))),
                new Customer("Ethan", List.of(new Order( 50.0), new Order( 75.0))),
                new Customer("Fiona", List.of(new Order( 120.0))),
                new Customer("George", List.of(new Order( 95.0), new Order(60.0))),
                new Customer("Hannah", List.of(new Order(170.0))),
                new Customer("Ian", List.of(new Order( 310.0))),
                new Customer("Jill", List.of(new Order( 220.0), new Order( 130.0)))
        );

        //How would you compute the total purchase amount for each customer and
        // then sort the customers by that amount in descending order?
//        List<Map.Entry<Customer, Double>> list = customers.stream().map(customer -> Map.entry(
//                customer, customer.orders().stream().mapToDouble(Order::purchaseAmount).sum()
//        )).sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue())).toList();
//        System.out.println(list);

        List<Map.Entry<String, Double>> list = customers.stream().map(customer -> Map.entry(
                customer.customerName(), customer.orders().stream().mapToDouble(Order::purchaseAmount).sum()
        )).sorted(Comparator.comparingDouble((Map.Entry<String, Double> e)-> e.getValue()).reversed()).toList();
        System.out.println(list);

    }
}
