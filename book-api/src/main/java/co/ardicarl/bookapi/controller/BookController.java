package co.ardicarl.bookapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ardicarl.bookapi.domain.Book;
import co.ardicarl.bookapi.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping
	public List<Book> findAllBooks() {
		return bookService.findAllBooks();
	}
	
	@GetMapping("/{bookId}")
	public Book findBook(@PathVariable Long bookId) {
		return bookService.findBookById(bookId).get();
	}
	
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}
	
	@DeleteMapping("/{bookId}")
	public void deleteBook(@PathVariable Long bookId) {
		bookService.deleteBook(bookId);
	}
	
	@PutMapping("/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable Long bookId) {
		return bookService.updateBook(book, bookId);	
	}
}
