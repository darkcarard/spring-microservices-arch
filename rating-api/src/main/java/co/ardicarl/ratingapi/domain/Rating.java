package co.ardicarl.ratingapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {
	
	private long id;
	private Long bookId;
	private int stars;
}
