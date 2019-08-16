package co.ardicarl.ratingapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.ardicarl.ratingapi.domain.Rating;
import co.ardicarl.ratingapi.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	private RatingService ratingService;

	@Autowired
	public RatingController(RatingService ratingService) {
		super();
		this.ratingService = ratingService;
	}

	@GetMapping
	public List<Rating> getRatingsBybookId(@RequestParam(required = false, defaultValue = "0") Long bookId) {
		if (bookId.equals(0L)) {
			return ratingService.findAllRatings();
		}
		return ratingService.findRatingsByBookId(bookId);
	}

	@PostMapping
	public Rating createRating(@RequestBody Rating rating) {
		return ratingService.createRating(rating);
	}

	@DeleteMapping("/{ratingId}")
	public void deleteRating(@PathVariable Long ratingId) {
		ratingService.deleteRating(ratingId);
	}

	@PutMapping("/{ratingId}")
	public Rating updateRating(@RequestBody Rating rating, @PathVariable Long ratingId) {
		return ratingService.updateRating(rating, ratingId);
	}
}
