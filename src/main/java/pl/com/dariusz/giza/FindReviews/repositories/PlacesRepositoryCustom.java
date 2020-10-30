package pl.com.dariusz.giza.FindReviews.repositories;

import org.springframework.stereotype.Repository;
import pl.com.dariusz.giza.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.model.Reviews;

import java.util.List;

@Repository
public interface PlacesRepositoryCustom {

    //    @Query(value = "{}", fields = "{id:1,name:1, address:1}")
    List<Places> findByCityAndSortByName(String city);

    List<Reviews> findReviewsByAuthorName(String name);
}
