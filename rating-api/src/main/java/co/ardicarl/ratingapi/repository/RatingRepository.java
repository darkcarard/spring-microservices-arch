package co.ardicarl.ratingapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ardicarl.ratingapi.domain.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
	List<Rating> findRatingsByBookId(Long bookId);
}
