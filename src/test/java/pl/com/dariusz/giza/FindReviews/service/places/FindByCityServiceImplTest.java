package pl.com.dariusz.giza.FindReviews.service.places;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindByCityServiceImplTest {

    @Test
    public void should_findByCity_throwsNullPointerException_when_cityIsNull() {

        //given
        String city = null;
        FindByCityServiceImpl findByCity = new FindByCityServiceImpl();
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> findByCity.findByCity(city));
    }

}