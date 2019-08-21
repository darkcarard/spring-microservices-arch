package co.ardicarl.bookapi.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
	@Id
	private long id;
	private String title;
	private String author;
}
