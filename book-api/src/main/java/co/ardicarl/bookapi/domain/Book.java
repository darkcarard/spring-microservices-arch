package co.ardicarl.bookapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
	private long id;
	private String title;
	private String author;
}
