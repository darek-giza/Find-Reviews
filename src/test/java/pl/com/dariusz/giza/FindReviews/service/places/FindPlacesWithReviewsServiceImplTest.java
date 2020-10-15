package pl.com.dariusz.giza.FindReviews.service.places;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.com.dariusz.giza.FindReviews.TestUtil;
import pl.com.dariusz.giza.FindReviews.model.places.Places;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FindPlacesWithReviewsServiceImplTest {

    @Mock
    private PlacesRepository placesRepository;

    @InjectMocks
    private FindPlacesWithReviewsServiceImpl findPlacesWithReviewsService;

    @Test
    public void findPlacesWithReviews() {
        //given
        List<Places> placesList = TestUtil.createListPlaces();
        when(placesRepository.findPlacesByReviewsIsNotNull()).thenReturn(placesList);
        //when
        List<Places> placesWithReviews = findPlacesWithReviewsService.findPlacesWithReviews();
        //then
        Assert.assertEquals(2, placesWithReviews.size());
        Assert.assertEquals(false, placesWithReviews.isEmpty());
        Assert.assertEquals(placesList.get(1).getId(),placesWithReviews.get(1).getId());
    }
}