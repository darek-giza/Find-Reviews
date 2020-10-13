package pl.com.dariusz.giza.FindReviews.service.places;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.com.dariusz.giza.FindReviews.model.places.Places;

class UpdatePlaceDetailsImplTest {


    @Test
    public void should_updatePlacesDetails_throwIllegalArgumentException_when_idIsNull(){

        //given
        String id = null;
        Places places = new Places();
        UpdatePlaceDetailsImpl updatePlaceDetails = new UpdatePlaceDetailsImpl();
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> updatePlaceDetails.update(id, places));
    }

    @Test
    public void should_updatePlacesDetails_throwIllegalArgumentException_when_placeIsNull(){

        //given
        String id = "5f804d040021851be2d06d7c";
        Places places = null;
        UpdatePlaceDetailsImpl updatePlaceDetails = new UpdatePlaceDetailsImpl();
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> updatePlaceDetails.update(id, places));
    }

}