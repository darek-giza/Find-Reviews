package pl.com.dariusz.giza.FindReviews.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import pl.com.dariusz.giza.FindReviews.model.places.Places;
import pl.com.dariusz.giza.FindReviews.model.places.Review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReviewsControllerTest {

    @Test
    public void getAll() {
        //given
        ReviewsController reviewsController = mock(ReviewsController.class);
        when(reviewsController.getAll()).thenReturn(prepareMockData());
        //when
        List<Places> allPlaces = reviewsController.getAll();
        //then
        assertThat(allPlaces, Matchers.hasSize(2));
        assertThat(allPlaces.get(0).getPlaceId(), Matchers.notNullValue());
        assertThat(allPlaces.get(0).getRatingAvg(), Matchers.nullValue());
        assertThat(allPlaces.get(1).getReviews().get(0).getText(), Matchers.notNullValue());
    }

    @Test
    public void getByCity() {
        //given
        String city = "Warszawa";
        ReviewsController reviewsController = mock(ReviewsController.class);
        when(reviewsController.getByCity(city)).thenReturn(prepareMockData());
        //when
        List<Places> byCity = reviewsController.getByCity(city);
        //then
        assertThat(byCity, Matchers.hasSize(2));
        assertThat(byCity.get(0).getFormattedAddress(), Matchers.matchesPattern(city));
        assertThat(byCity.get(1).getFormattedAddress(), Matchers.matchesPattern(city));
    }

    private List<Places> prepareMockData() {
        List<String> typesList = new ArrayList<>();
        typesList.add("spa");

        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("Darek", "pl", 1, "45454",
                "text", 444444));

        List<Places> listPlaces = new LinkedList<>();
        listPlaces.add(new Places("Spa", "Warszawa", "000",
                "https://", "htpps://", "dfgh345", typesList));
        listPlaces.add(new Places("Spa", "Warszawa", "997",
                "https://", "htpps://", "dfgh345wsd3", typesList, 1d, reviews));
        return listPlaces;
    }
}