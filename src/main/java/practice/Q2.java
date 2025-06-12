package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q2 {
    //Suppose you have a list of products with name and price.
    // How would you sort the products in ascending order of price using Java 8 streams?
    static class Product{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        String name;
        double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
    public static void main(String[] args) {
        List<Product> listOfProducts = Arrays.asList(
                new Product("Laptop", 999.99),
                new Product("Smartphone", 749.50),
                new Product("Tablet", 450.00),
                new Product("Headphones", 129.95),
                new Product("Smartwatch", 199.99),
                new Product("Camera", 549.25),
                new Product("Printer", 149.80),
                new Product("Monitor", 299.99),
                new Product("Keyboard", 89.99),
                new Product("Mouse", 45.75),
                new Product("Speaker", 120.00),
                new Product("Router", 179.50),
                new Product("Hard Drive", 99.99),
                new Product("USB Cable", 15.99),
                new Product("Charger", 25.50),
                new Product("Webcam", 85.00),
                new Product("Microphone", 130.25),
                new Product("Projector", 650.00),
                new Product("Drone", 999.00),
                new Product("TV", 1200.00)
        );

//        How would you sort the products in ascending order of price using Java 8 streams?
//          List<Product> sorted = listOfProducts.stream().sorted(Comparator.comparingDouble(Product::getPrice)).collect(Collectors.toList());
//          List<Product> sorted = listOfProducts.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).collect(Collectors.toList());
        List<Product> collect = listOfProducts.stream().sorted(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o2.getPrice() - o1.getPrice());
            }
        }).collect(Collectors.toList());
        System.out.println(collect);
    }
}
