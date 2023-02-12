package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookStore {

	public static void main(String[] args) {
		SpringApplication.run(BookStore.class, args);
	}

	@Bean
    public CommandLineRunner demo(BookRepository repository, CategoryRepository Crepository) {
        return (args) -> {
        	Category c1 = new Category("Novels");
        	Category c2 = new Category("History");
        	Crepository.save(c1);
        	Crepository.save(c2);
        	//Book b1 = new Book(Crepository.findById((long) 1), "A Farewell to Arms", "Ernest Hemingway", 1929, "123123-23", 55);
        	//Book b2 = new Book("Value Books", "Animal Farm", "George Orwell", 1945, "456654-5", 46);
        	//repository.save(b1);
        	//repository.save(b2);
        };
    }
}
