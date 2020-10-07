package pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesByType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.googleApi.details.Details;
import pl.com.dariusz.giza.FindReviews.model.googleApi.nearbySearch.NearbyPlaces;
import pl.com.dariusz.giza.FindReviews.model.googleApi.nearbySearch.Result;
import pl.com.dariusz.giza.FindReviews.service.googleApi.details.DetailsService;
import pl.com.dariusz.giza.FindReviews.service.googleApi.nearbysearch.NearbySearchService;
import pl.com.dariusz.giza.FindReviews.service.googleApi.searchAutocomplete.SearchService;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FindServiceImpl implements FindService {

    private final SearchService searchService;
    private final DetailsService detailsService;
    private final NearbySearchService nearbySearchService;

    @Autowired
    public FindServiceImpl(SearchService searchService, DetailsService detailsService,
                           NearbySearchService nearbySearchService) {
        this.searchService = searchService;
        this.detailsService = detailsService;
        this.nearbySearchService = nearbySearchService;
    }

    @Override
    public Set<Details> findPlacesDetails(String city, String types) throws IOException {

        final String placeId = searchService
                .search(city)
                .getPredictions()
                .get(0)
                .getPlaceId();

        final Details detail = detailsService.getDetails(placeId);

        final Double lat = detail.getResult().getGeometry().getLocation().getLat();
        final Double lng = detail.getResult().getGeometry().getLocation().getLng();

        final NearbyPlaces nearbysearch = nearbySearchService.nearbysearch(types, lat, lng, 10000, null,
                null, null, null, true);

        final List<Result> places = nearbysearch.getResults();

        final Set<String> id = places
                .stream()
                .map(i -> i.getPlaceId())
                .collect(Collectors.toSet());

        final Set<Details> allPlacesDetails = detailsService.getAllPlacesDetails(id);

        return allPlacesDetails;

    }
}
