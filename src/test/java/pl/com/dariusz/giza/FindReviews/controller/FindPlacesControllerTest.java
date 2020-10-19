package pl.com.dariusz.giza.FindReviews.controller;

import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.com.dariusz.giza.FindReviews.TestUtilDetails;
import pl.com.dariusz.giza.FindReviews.model.googleApiModels.details.Details;
import pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesService.FindService;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner.class)
public class FindPlacesControllerTest {

    private MockMvc mock;

    @Mock
    private FindService findService;

    @InjectMocks
    private FindPlacesController findPlacesController;

    @Before
    public void init() {
        this.mock = MockMvcBuilders.standaloneSetup(findPlacesController).build();
    }

    @Test
    public void find() throws Exception {
        Set<Details> setDetails = TestUtilDetails.createListDetails();
        when(findService.findPlacesDetails(any(), any())).thenReturn(setDetails);
        RequestBuilder request = MockMvcRequestBuilders.get("/find?city=Puławy&types=spa");
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(1)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void findFail() throws Exception {
        Set<Details> emptySet = new HashSet<>();
        when(findService.findPlacesDetails(any(), any())).thenReturn(emptySet);
        RequestBuilder request = MockMvcRequestBuilders.get("/find");
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}