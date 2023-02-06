package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@Controller

public class BookController {

	@Autowired
	private BookRepository repository;

	@GetMapping("/index")
	public String book(Model model) {
		return "index";
	}

	@GetMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@GetMapping("/add")
	public String addBookForm(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	@PostMapping("/add")
	public String addBook(@ModelAttribute Book book) {
		repository.save(book);
		return "redirect:/booklist";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:/booklist";
	}

	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") long id, Model model) {
		Book book = repository.findById(id).get();
		model.addAttribute("book", book);
		return "editbook";
	}

	@PostMapping("/edit/{id}")
	public String updateBook(@PathVariable("id") long id, @ModelAttribute Book book) {
		book.setId(id);
		repository.save(book);
		return "redirect:/booklist";
	}

}
