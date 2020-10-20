package pl.com.dariusz.giza.FindReviews.FindReviews;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import pl.com.dariusz.giza.FindReviews.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.FindReviews.model.Review;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    public static String createStringWithLength(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append("a");
        }
        return builder.toString();
    }

    public static String asJsonString(Object obj) throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        String jsonContent = mapper.writeValueAsString(obj);
        return jsonContent;
    }

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
