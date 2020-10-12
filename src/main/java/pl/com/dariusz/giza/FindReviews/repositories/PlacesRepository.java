package pl.com.dariusz.giza.FindReviews.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.com.dariusz.giza.FindReviews.model.places.Places;

import java.util.*;

@Repository
public interface PlacesRepository extends MongoRepository<Places, String> {

    List<Places> findByFormattedAddressIsContaining(String city);

    List<Places> findPlacesByReviewsIsNotNull();

}
