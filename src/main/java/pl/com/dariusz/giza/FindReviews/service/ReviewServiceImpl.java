package pl.com.dariusz.giza.FindReviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.Reviews;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepositoryCustom;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {


    private PlacesRepositoryCustom placesRepositoryCustom;

    @Autowired
    public ReviewServiceImpl(PlacesRepositoryCustom placesRepositoryCustom) {
        this.placesRepositoryCustom = placesRepositoryCustom;
    }

    @Override
    public List<Reviews> getReviews(String authorName) {

        final List<Reviews> reviewsByAuthorName = placesRepositoryCustom.findReviewsByAuthorName(authorName);

        return reviewsByAuthorName.stream().sorted((o1, o2) -> {
            if (o2 == null) return -1;
            int i = o1.getAuthorName().compareTo(o2.getAuthorName());
            if (i > 0) return 1;
            if (i < 0) return -1;
            else return 0;
        }).collect(Collectors.toList());
    }
}
