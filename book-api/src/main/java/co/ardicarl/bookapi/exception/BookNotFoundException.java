package co.ardicarl.bookapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1456531170299542293L;

	public BookNotFoundException(String message) {
		super(message);
	}
}
