package co.ardicarl.ratingapi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rating {
	
	@Id
	private long id;
	private Long bookId;
	private int stars;
}
