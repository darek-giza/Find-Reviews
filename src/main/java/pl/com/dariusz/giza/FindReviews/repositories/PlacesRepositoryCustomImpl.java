package pl.com.dariusz.giza.FindReviews.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import pl.com.dariusz.giza.FindReviews.model.Places;

import java.util.List;

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
}
