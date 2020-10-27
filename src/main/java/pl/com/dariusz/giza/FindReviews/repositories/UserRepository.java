package pl.com.dariusz.giza.FindReviews.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.com.dariusz.giza.FindReviews.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
