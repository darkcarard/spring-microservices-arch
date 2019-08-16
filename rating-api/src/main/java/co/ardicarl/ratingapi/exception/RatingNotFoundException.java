package co.ardicarl.ratingapi.exception;

public class RatingNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5145298853587790960L;

	public RatingNotFoundException(String message) {
		super(message);
	}
}
