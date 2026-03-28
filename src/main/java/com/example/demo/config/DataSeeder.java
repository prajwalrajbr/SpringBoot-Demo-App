package com.example.demo.config;

import java.util.List;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataSeeder(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        if (bookRepository.count() == 0) {
            bookRepository.saveAll(List.of(
                    new Book("The Great Gatsby", "F. Scott Fitzgerald"),
                    new Book("To Kill a Mockingbird", "Harper Lee"),
                    new Book("1984", "George Orwell")
            ));
            System.out.println("Seeded 3 books into MongoDB.");
        }
    }
}
