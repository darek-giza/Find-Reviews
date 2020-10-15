package pl.com.dariusz.giza.FindReviews.service.googleApi.searchAutocomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

class SearchServiceImplTest {

    final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";

    @Test
    public void should_search_throwIllegalArgumentException_when_inputIsNull(){
        //given
        String input = null;
        SearchServiceImpl searchService = new SearchServiceImpl();
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> searchService.search(input));
    }

    @Test
    public void should_createStringBuilderObject() {
        //when
        StringBuilder sb = new StringBuilder(PLACES_API_BASE);
        //then
        Assertions.assertEquals(58, sb.capacity());
        Assertions.assertEquals(42, sb.length());
    }

    @Test
    public void should_create_and_append_string_to_SbObject() {
        //given
        String TYPE_SEARCH_AUTOCOMPLETE = "/autocomplete";
        String OUT_JSON = "/json";
        String input = "London";
        //when
        StringBuilder sb = new StringBuilder(PLACES_API_BASE);
        sb.append(TYPE_SEARCH_AUTOCOMPLETE);
        sb.append(OUT_JSON);
        sb.append("?input=" + input);
        //then
        Assertions.assertEquals("https://maps.googleapis.com/maps/api/place/autocomplete/json?input=London",
                sb.toString());

    }
    @Test
    public void should_create_urlObject() throws MalformedURLException {
        //given
        String s="https://maps.googleapis";
        //when
        URL url = new URL(s.toString());
        //then
        Assertions.assertEquals(s,url.toString());
    }

}