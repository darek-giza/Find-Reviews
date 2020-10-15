package pl.com.dariusz.giza.FindReviews.service.places;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.com.dariusz.giza.FindReviews.TestUtil;
import pl.com.dariusz.giza.FindReviews.model.places.Places;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UpdatePlaceDetailsServiceImplTest {

    @Mock
    private PlacesRepository placesRepository;

    @InjectMocks
    private UpdatePlaceDetailsServiceImpl updatePlaceDetailsService;

    @Test
    public void update() {
        //given
        List<Places> placesList = TestUtil.createListPlaces();
        final Places places = placesList.get(0);
        final String id = placesList.get(0).getId();
        when(placesRepository.findAllById(any())).thenReturn(placesList);
        //when
        updatePlaceDetailsService.update(any(), any());
        //then
        verify(placesRepository, times(1)).save(any());
    }


    @Test
    public void should_updatePlacesDetails_throwIllegalArgumentException_when_idIsNull() {

        //given
        String id = null;
        Places places = new Places();
        UpdatePlaceDetailsServiceImpl updatePlaceDetails = new UpdatePlaceDetailsServiceImpl();
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> updatePlaceDetails.update(id, places));
    }

    @Test
    public void should_updatePlacesDetails_throwIllegalArgumentException_when_placeIsNull(){

        //given
        String id = "5f804d040021851be2d06d7c";
        Places places = null;
        UpdatePlaceDetailsServiceImpl updatePlaceDetails = new UpdatePlaceDetailsServiceImpl();
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> updatePlaceDetails.update(id, places));
    }

}