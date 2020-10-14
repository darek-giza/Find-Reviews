package pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.googleApiModels.details.Details;
import pl.com.dariusz.giza.FindReviews.model.googleApiModels.nearbySearch.NearbyPlaces;
import pl.com.dariusz.giza.FindReviews.service.googleApi.details.DetailsService;
import pl.com.dariusz.giza.FindReviews.service.googleApi.nearbysearch.NearbySearchService;
import pl.com.dariusz.giza.FindReviews.service.googleApi.searchAutocomplete.SearchService;

import java.io.IOException;
import java.util.HashSet;
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
    public Set<Details> findPlacesDetails(String city, String types) throws IOException, NullPointerException {

        int radius = 1000;
        String keywords = null;
        String language = null;
        Integer minprice = null;
        String name = null;
        boolean opennow = true;

        final String placeId = searchService
                .search(city)
                .getPredictions()
                .get(0)
                .getPlaceId();

        final Details detail = detailsService.getDetails(placeId);

        final Double lat = detail.getResult().getGeometry().getLocation().getLat();
        final Double lng = detail.getResult().getGeometry().getLocation().getLng();

        final NearbyPlaces nearbysearch = nearbySearchService.nearbysearch(types, lat, lng, radius, keywords,
                language, minprice, name, opennow);

        final Set<String> id = nearbysearch.getResults()
                .stream()
                .map(i -> i.getPlaceId())
                .collect(Collectors.toSet());

        return new HashSet<>(detailsService.getAllPlacesDetails(id));
    }
}
