package pl.com.dariusz.giza.FindReviews.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.com.dariusz.giza.FindReviews.TestUtil;
import pl.com.dariusz.giza.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UpdatePlacesDetailsDaoImplTest {

    @Mock
    private PlacesRepository placesRepository;

    @InjectMocks
    private UpdatePlaceDetailsServiceImpl updatePlaceDetailsService;

    @Test
    public void update() {
        //given
        final Places place = TestUtil.createListPlaces().get(0);
        final String id = place.getId();
        when(placesRepository.findById(any())).thenReturn(java.util.Optional.of(place));
        //when
        updatePlaceDetailsService.update(id,place);
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