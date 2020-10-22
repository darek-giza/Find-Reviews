package pl.com.dariusz.giza.FindReviews.repositories;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pl.com.dariusz.giza.FindReviews.model.Places;

import java.util.List;

@Primary
@Repository
public interface PlacesRepository extends MongoRepository<Places, String>, PlacesRepositoryCustom {

    @Query(value = "{}", fields = "{id:1,name:1, address:1}")
    List<Places> findByFormattedAddressIsContaining(String city);

    List<Places> findPlacesByReviewsIsNotNull();

    List<Places> findByAddress_Locality(String locality);

}
