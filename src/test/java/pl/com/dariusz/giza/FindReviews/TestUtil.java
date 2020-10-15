package pl.com.dariusz.giza.FindReviews;

import pl.com.dariusz.giza.FindReviews.model.places.Places;
import pl.com.dariusz.giza.FindReviews.model.places.Review;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static List<Places> createListPlaces() {
        List<Places> places = new ArrayList<>();
        places.add(getPlace1());
        places.add(getPlace2());
        return places;
    }

    public static Places getPlace1() {
        Places place1 = new Places();
        place1.setId("1");
        place1.setName("Spa");
        place1.setFormattedAddress("Warszawa");
        place1.setFormattedPhoneNumber("007823");
        place1.setUrl("http://");
        place1.setWebsite("http://");
        place1.setPlaceId("fdibdkwbecwc2n");
        place1.setTypes(getTypesList());
        return place1;

    }

    public static Places getPlace2() {
        Places place2 = new Places();
        place2.setId("2");
        place2.setName("Spa&Fit");
        place2.setFormattedAddress("Warszawa");
        place2.setFormattedPhoneNumber("0032223");
        place2.setUrl("https://");
        place2.setWebsite("https://");
        place2.setPlaceId("fdihrxtrchcwc2n");
        place2.setTypes(getTypesList());
        place2.setRatingAvg(1d);
        place2.setReviews(getReviews());
        return place2;

    }

    public static List<String> getTypesList() {
        List<String> typesList = new ArrayList<>();
        typesList.add(0, "spa");
        typesList.add(1, "food");
        return typesList;
    }

    public static List<Review> getReviews() {
        List<Review> reviews = new ArrayList<>();
        Review review = new Review();
        reviews.add(review);
        review.setAuthorName("Darek");
        review.setLanguage("pl");
        review.setRating(1);
        review.setRelativeTimeDescription("6564647646");
        review.setText("text");
        review.setTime(44444555);
        return reviews;
    }
}
