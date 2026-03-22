package com.example.demo;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    private static final List<Book> BOOKS = List.of(
            new Book("1", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("2", "To Kill a Mockingbird", "Harper Lee"),
            new Book("3", "1984", "George Orwell")
    );

    @QueryMapping
    public List<Book> books() {
        return BOOKS;
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return BOOKS.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
