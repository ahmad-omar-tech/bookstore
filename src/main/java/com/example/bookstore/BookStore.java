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
    public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository) {
        return (args) -> {
        	categoryRepository.save(new Category("Romance"));
        	categoryRepository.save(new Category("Fantasy"));
        	Book b1 = new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "123123-23", 55, categoryRepository.findByName("Romance"));
        	Book b2 = new Book("Animal Farm", "George Orwell", 1945, "456654-5", 46,categoryRepository.findByName("Fantasy"));
        	repository.save(b1);
        	repository.save(b2);
        };
    }
}
