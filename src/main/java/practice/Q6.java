package practice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q6 {
    //Assume a list of books where each book has a title and yearPublished.
    // How would you sort the books by year, and then by title alphabetically in case of a tie?
    public record Book(String title, int yearPublished) {
    }

    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("The Great Gatsby", 1925),
                new Book("To Kill a Mockingbird", 1960),
                new Book("1984", 1949),
                new Book("Pride and Prejudice", 1813),
                new Book("The Catcher in the Rye", 1951),
                new Book("The Hobbit", 1847),
                new Book("Fahrenheit 451", 1953),
                new Book("The Lord of the Rings", 1954),
                new Book("Brave New World", 1932),
                new Book("Jane Eyre", 1847)
        );

//        List<Book> sortedBook = books.stream().sorted(Comparator.comparingInt(Book::yearPublished).thenComparing(Book::title)).collect(Collectors.toList());
        List<Book> sortedBook = books.stream().sorted(Comparator.comparing(Book::yearPublished, Comparator.naturalOrder()).thenComparing(Book::title, Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(sortedBook);
    }
}
