package co.ardicarl.bookapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.ardicarl.bookapi.domain.model.Book;
import co.ardicarl.bookapi.domain.repository.BookRepository;
import co.ardicarl.bookapi.exception.BookNotFoundException;

@Service
@Transactional(readOnly = true)
public class BookService {

	private BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public Optional<Book> findBookById(Long bookId) {
		return Optional.ofNullable(bookRepository.findById(bookId))
				.orElseThrow(() -> new BookNotFoundException("Book not found. ID: " + bookId));
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Book	createBook(Book book) {
		final Book newBook = new Book();
		newBook.setTitle(book.getTitle());
		newBook.setAuthor(book.getTitle());
		
		return bookRepository.save(newBook);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Book updateBook(Book book, Long bookId) {
		book.setId(bookId);
		return bookRepository.save(book);
	}
}
