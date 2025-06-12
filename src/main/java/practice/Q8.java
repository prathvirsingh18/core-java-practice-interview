package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q8 {
//    Given a list of Product objects with fields like name, price, and unitsSold,
//    how would you sort them in descending order of unitsSold and get the top 5 products?
    public record Product(String name, double price, int unitSold){};

    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product("Laptop", 999.99, 150),
                new Product("Phone", 799.99, 300),
                new Product("Tablet", 399.99, 200),
                new Product("Monitor", 199.99, 180),
                new Product("Keyboard", 49.99, 90),
                new Product("Mouse", 29.99, 120),
                new Product("Printer", 149.99, 80),
                new Product("Speaker", 89.99, 110),
                new Product("Camera", 549.99, 75),
                new Product("Charger", 19.99, 220)
        );
//    how would you sort them in descending order of unitsSold and get the top 5 products?
        List<Product> outputList = productList.stream().sorted(Comparator.comparing(Product::unitSold, Comparator.reverseOrder()))
                .limit(5).toList();
        System.out.println(outputList);
        Map<String, Double> collect = productList.stream().sorted(Comparator.comparing(Product::unitSold, Comparator.reverseOrder()))
                .limit(5).collect(Collectors.toMap(Product::name, Product::price));
        System.out.println(collect);
    }
}
