package pl.com.dariusz.giza.FindReviews.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.com.dariusz.giza.FindReviews.TestUtil;
import pl.com.dariusz.giza.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PlacesServiceImplTest {

    @Mock
    private PlacesRepository placesRepository;

    @InjectMocks
    private PlacesServiceImpl placesService;

    @Test
    public void getAll() {
        //given
        List<Places> placesList = TestUtil.createListPlaces();
        when(placesRepository.findAll()).thenReturn(placesList);
        //when
        List<Places> findAllResults = placesService.getAll();
        //then
        Assert.assertEquals(2, findAllResults.size());
        assertThat(findAllResults, Matchers.hasSize(2));
        assertThat(findAllResults.get(0).getPlaceId(), Matchers.notNullValue());
        assertThat(findAllResults.get(0).getRatingAvg(), Matchers.nullValue());
        assertThat(findAllResults.get(1).getReviews().get(0).getText(), Matchers.notNullValue());
    }

    @Test
    public void save() {
        //given
        List<Places> placesList = TestUtil.createListPlaces();
        when(placesRepository.saveAll(anyList())).thenReturn((placesList));
        //when
        List<Places> places = placesService.save(placesList);
        //then
        Assert.assertEquals(placesList.get(0).getPlaceId(), places.get(0).getPlaceId());
        Assert.assertEquals(placesList.size(), places.size());
        assertThat("Warszawa", places.get(0).getFormattedAddress().contains("Warszawa"));
    }

    @Test
    public void delete() {
        //given
        List<Places> placesList = TestUtil.createListPlaces();
        final String placeId = placesList.get(0).getId();
        doNothing().when(placesRepository).deleteById(placeId);
        //then
        placesService.delete(placeId);
        verify(placesRepository, times(1)).deleteById(placeId);

    }
}