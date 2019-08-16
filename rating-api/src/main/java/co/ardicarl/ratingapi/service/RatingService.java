package co.ardicarl.ratingapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.ardicarl.ratingapi.domain.Rating;
import co.ardicarl.ratingapi.exception.RatingNotFoundException;
import co.ardicarl.ratingapi.repository.RatingRepository;

@Service
@Transactional(readOnly = true)
public class RatingService {
	
	private RatingRepository ratingRepository;

	@Autowired
	public RatingService(RatingRepository ratingRepository) {
		super();
		this.ratingRepository = ratingRepository;
	}
	
	public List<Rating> findRatingsByBookId(Long bookId) {
		return ratingRepository.findRatingsByBookId(bookId);
	}
	
	public List<Rating> findAllRatings() {
		return ratingRepository.findAll();
	}
	
	public Optional<Rating> findRatingById(Long ratingId) {
        return Optional.ofNullable(ratingRepository.findById(ratingId))
            .orElseThrow(() -> new RatingNotFoundException("Rating not found. ID: " + ratingId));
    }
	
	@Transactional(propagation = Propagation.REQUIRED)
    public Rating createRating(Rating rating) {
        Rating newRating = new Rating();
        newRating.setBookId(rating.getBookId());
        newRating.setStars(rating.getStars());
        Rating persisted = ratingRepository.save(newRating);
        
        return persisted;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public Rating updateRating(Rating rating, Long ratingId) {        
        return ratingRepository.save(rating);
    }
}

