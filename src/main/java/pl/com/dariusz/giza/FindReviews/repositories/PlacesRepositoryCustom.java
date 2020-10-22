package pl.com.dariusz.giza.FindReviews.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pl.com.dariusz.giza.FindReviews.model.Places;

import java.util.List;

@Repository
public interface PlacesRepositoryCustom {

//    @Query(value = "{}", fields = "{id:1,name:1, address:1}")
    List<Places> findByCityAndSortByName(String city);
}
