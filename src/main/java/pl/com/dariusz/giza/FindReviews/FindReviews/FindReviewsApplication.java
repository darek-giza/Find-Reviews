package pl.com.dariusz.giza.FindReviews.FindReviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FindReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindReviewsApplication.class, args);
	}

}
