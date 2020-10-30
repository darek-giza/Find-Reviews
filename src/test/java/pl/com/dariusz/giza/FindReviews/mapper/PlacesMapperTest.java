package pl.com.dariusz.giza.FindReviews.mapper;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import pl.com.dariusz.giza.FindReviews.TestUtil;
import pl.com.dariusz.giza.FindReviews.dto.PlaceDto;
import pl.com.dariusz.giza.FindReviews.model.Places;

@RunWith(MockitoJUnitRunner.class)
public class PlacesMapperTest {

    @Test
    public void shouldMapPlaceEntity() {
        //when
        final ModelMapper modelMapper = new ModelMapper();
        final PlaceMapper placeMapper = new PlaceMapper(modelMapper);
        final Places place = TestUtil.getPlace2();
        //given
        final PlaceDto placeDto = placeMapper.convertPlaceToDto(place);
        //then
        Assertions.assertEquals(place.getName(), placeDto.getName());
        Assertions.assertEquals(place.getRatingAvg(), placeDto.getRatingAvg());
        Assertions.assertEquals(place.getReviews().size(), placeDto.getReviews().size());
    }

    @Test
    public void shouldInstantiateMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        Assertions.assertTrue(Matchers.notNullValue().matches(modelMapper));
    }
}
