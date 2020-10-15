package pl.com.dariusz.giza.FindReviews.service.places;

import org.junit.Assert;
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

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FindByCityServiceImplTest {

    @Mock
    private PlacesRepository placesRepository;

    @InjectMocks
    private FindByCityServiceImpl findByCityService;

    @Test
    public void findByCity() {
        //given
        String city = "Warszawa";
        List<Places> placesList = TestUtil.createListPlaces();
        when(placesRepository.findByFormattedAddressIsContaining(city)).thenReturn(placesList);
        //when
        List<Places> byCity = findByCityService.findByCity(city);
        //then
        Assert.assertEquals(2, byCity.size());
        Assert.assertEquals(true, byCity.get(0).getFormattedAddress().contains(city));
        Assert.assertEquals(placesList.get(0).getName(), byCity.get(0).getName());
    }


    @Test
    public void should_findByCity_throwsNullPointerException_when_cityIsNull() {
        //given
        String city = null;
        FindByCityServiceImpl findByCity = new FindByCityServiceImpl();
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> findByCity.findByCity(city));
    }

}