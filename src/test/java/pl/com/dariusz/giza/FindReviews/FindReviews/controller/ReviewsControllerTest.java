package pl.com.dariusz.giza.FindReviews.FindReviews.controller;

import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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
import pl.com.dariusz.giza.FindReviews.FindReviews.TestUtil;
import pl.com.dariusz.giza.FindReviews.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.FindReviews.service.FindPlacesWithReviewsService;
import pl.com.dariusz.giza.FindReviews.FindReviews.service.UpdatePlaceDetailsService;
import pl.com.dariusz.giza.FindReviews.FindReviews.service.FindByCityService;
import pl.com.dariusz.giza.FindReviews.FindReviews.service.PlacesService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner.class)
public class ReviewsControllerTest {

    private MockMvc mock;

    @Mock
    private PlacesService placesService;

    @Mock
    private FindByCityService findByCityService;

    @Mock
    private FindPlacesWithReviewsService findPlacesWithReviewsService;

    @Mock
    private UpdatePlaceDetailsService updatePlaceDetailsService;

    @InjectMocks
    private ReviewsController reviewsController;

    @Before
    public void init() {
        this.mock = MockMvcBuilders.standaloneSetup(reviewsController).build();

    }

    @Test
    public void getAll() throws Exception {
        List<Places> list = TestUtil.createListPlaces();
        when(placesService.getAll()).thenReturn(list);
        RequestBuilder request = MockMvcRequestBuilders.get("/api/getAll");
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(2)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAllFail() throws Exception {
        List<Places> emptyList = new ArrayList<>();
        when(placesService.getAll()).thenReturn(emptyList);
        RequestBuilder request = MockMvcRequestBuilders.get("/api/getAll");
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void getByCity() throws Exception {
        List<Places> list = TestUtil.createListPlaces();
        when(findByCityService.findByCity("Warszawa")).thenReturn(list);
        RequestBuilder request = MockMvcRequestBuilders.get("/api/getByCity?city=Warszawa");
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(2)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getByCityFail() throws Exception {
        List<Places> emptyList = new ArrayList<>();
        when(findByCityService.findByCity("Warszawa")).thenReturn(emptyList);
        RequestBuilder request = MockMvcRequestBuilders.get("/api/getByCity?city=Warszawa");
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    @Test
    public void getWithReviews() throws Exception {
        List<Places> list = TestUtil.createListPlaces();
        when(findPlacesWithReviewsService.findPlacesWithReviews()).thenReturn(list);
        RequestBuilder request = MockMvcRequestBuilders.get("/api/getPlacesWithReviews");
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(2)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getWithReviewsFail() throws Exception {
        List<Places> emptyList = new ArrayList<>();
        when(findPlacesWithReviewsService.findPlacesWithReviews()).thenReturn(emptyList);
        RequestBuilder request = MockMvcRequestBuilders.get("/api/getPlacesWithReviews");
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    @Test
    public void addPlacesList() throws Exception {
        List<Places> list = TestUtil.createListPlaces();
        final String json = TestUtil.asJsonString(list);
        when(placesService.save(any())).thenReturn(list);
        RequestBuilder request = MockMvcRequestBuilders.post("/api/addPlaces")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(list.get(0).getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is(list.get(0).getName())))
                .andDo(MockMvcResultHandlers.print());


        ArgumentCaptor<List<Places>> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(placesService, times(1)).save(argumentCaptor.capture());
        verifyNoMoreInteractions(placesService);
    }

    @Test
    public void addPlacesFail() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/api/addPlaces");
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void update() throws Exception{
        Places place = TestUtil.getPlace1();
        final String json = TestUtil.asJsonString(place);
        when(updatePlaceDetailsService.update(any(),any())).thenReturn(place);
        RequestBuilder request = MockMvcRequestBuilders.put("/api/updatePlace?id={id}",place.getId())
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(place.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(place.getName())))
                .andDo(MockMvcResultHandlers.print());

        ArgumentCaptor<Places> argumentCaptor = ArgumentCaptor.forClass(Places.class);
        verify(updatePlaceDetailsService, times(1)).update(any(),argumentCaptor.capture());
        verifyNoMoreInteractions(updatePlaceDetailsService);
    }

    @Test
    public void updateFail() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.put("/api/updatePlace?id=1");
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void deletePlaceById() throws Exception {
        final Places place = TestUtil.getPlace2();
        when(placesService.getById(any())).thenReturn(place);
        doNothing().when(placesService).delete(place.getId());
        RequestBuilder request = MockMvcRequestBuilders.delete("/api/deletePlaceById?id=2");
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(placesService, times(1)).getById(place.getId());
        verify(placesService, times(1)).delete(place.getId());
        verifyNoMoreInteractions(placesService);
    }

    @Test
    public void deletePlacesByIdFail() throws Exception {
        Places place = TestUtil.getPlace2();
        when(placesService.getById(any())).thenReturn(null);
        RequestBuilder request = MockMvcRequestBuilders.delete("/api/deletePlaceById?id=2");
        mock.perform(request)
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        verify(placesService, times(1)).getById(place.getId());
        verifyNoMoreInteractions(placesService);

    }
}