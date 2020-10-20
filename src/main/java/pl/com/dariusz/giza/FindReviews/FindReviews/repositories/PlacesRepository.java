package pl.com.dariusz.giza.FindReviews.FindReviews.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.com.dariusz.giza.FindReviews.FindReviews.model.Places;

import java.util.List;

@Repository
public interface PlacesRepository extends MongoRepository<Places, String> {

    List<Places> findByFormattedAddressIsContaining(String city);

    List<Places> findPlacesByReviewsIsNotNull();

}
