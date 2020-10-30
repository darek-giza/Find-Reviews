package pl.com.dariusz.giza.FindReviews.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import pl.com.dariusz.giza.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.model.Reviews;

import java.util.List;
import java.util.NoSuchElementException;

public class PlacesRepositoryCustomImpl implements PlacesRepositoryCustom {

    private MongoTemplate mongoTemplate;

    @Autowired
    public PlacesRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Places> findByCityAndSortByName(String city) {

        Query query = new Query()
                .addCriteria(Criteria.where("address.locality").is(city))
                .with(Sort.by("name").descending());
        return mongoTemplate.find(query, Places.class);
    }

    @Override
    public List<Reviews> findReviewsByAuthorName(String authorName) {
        Query query = new Query()
                .addCriteria(Criteria.where("reviews.authorName").is(authorName));
        List<Reviews> reviewsList;
        reviewsList = mongoTemplate.find(query, Reviews.class);
        if (reviewsList == null) {
            throw new NoSuchElementException("Collection is empty");
        }
        return reviewsList;
    }
}
