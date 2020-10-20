package pl.com.dariusz.giza.FindReviews.FindReviews.dao.googlePlacesApiDao;

import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Review;
import pl.com.dariusz.giza.FindReviews.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Details;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ParsedDaoImpl implements ParsedDao {


    @Override
    public Set<Places> parse(Set<Details> setDetails) {
        Set<Places> setPlaces = new HashSet<>();
        setDetails.forEach(i -> {
            String placeName = i.getResult().getName();
            String address = i.getResult().getFormattedAddress();
            String phone = i.getResult().getFormattedPhoneNumber();
            String url = i.getResult().getUrl();
            String website = i.getResult().getWebsite();
            String placeId1 = i.getResult().getPlaceId();
            List<String> type = i.getResult().getTypes();
            List<Review> reviews = i.getResult().getReviews();

            if (reviews != null) {
                List<pl.com.dariusz.giza.FindReviews.FindReviews.model.Review> reviewsDto = new ArrayList<>();

                Integer ratingSum = i.getResult().getReviews()
                        .stream()
                        .map(r -> r.getRating())
                        .reduce(Integer::sum).get();
                int count = (int) i.getResult().getReviews().stream().map(r -> r.getRating()).count();
                Double ratingAvg = Double.valueOf(ratingSum / count);

                reviews.forEach(r -> {
                    String authorName = r.getAuthorName();
                    String lang = r.getLanguage();
                    Integer rating = r.getRating();
                    String relativeTimeDescription = r.getRelativeTimeDescription();
                    String text = r.getText();
                    Integer time = r.getTime();
                    reviewsDto.add(new pl.com.dariusz.giza.FindReviews.FindReviews.model.Review(authorName, lang, rating, relativeTimeDescription, text, time));
                });
                setPlaces.add(new Places(placeName, address, phone, url, website, placeId1, type, ratingAvg, reviewsDto));
            } else {
                setPlaces.add(new Places(placeName, address, phone, url, website, placeId1, type));
            }
        });
        return setPlaces;
    }
}

