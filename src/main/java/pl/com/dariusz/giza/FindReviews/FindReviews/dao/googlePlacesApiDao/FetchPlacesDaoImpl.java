package pl.com.dariusz.giza.FindReviews.FindReviews.dao.googlePlacesApiDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.dao.detailsDao.DetailsDao;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.dao.nearbySearchDao.NearbySearchDao;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Details;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.nearbySearch.NearbyPlaces;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.dao.searchAutocompleteDao.SearchDao;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FetchPlacesDaoImpl implements FetchPlacesDao {

    private final SearchDao searchDao;
    private final DetailsDao detailsDao;
    private final NearbySearchDao nearbySearchDao;

    @Autowired
    public FetchPlacesDaoImpl(SearchDao searchDao, DetailsDao detailsDao,
                              NearbySearchDao nearbySearchDao) {
        this.searchDao = searchDao;
        this.detailsDao = detailsDao;
        this.nearbySearchDao = nearbySearchDao;
    }

    @Override
    public Set<Details> fetchPlacesDetails(String city, String types) throws IOException, NullPointerException {

        int radius = 1000;
        String keywords = null;
        String language = null;
        Integer minprice = null;
        String name = null;
        boolean opennow = true;

        final String placeId = searchDao
                .search(city)
                .getPredictions()
                .get(0)
                .getPlaceId();

        final Details detail = detailsDao.getDetails(placeId);

        final Double lat = detail.getResult().getGeometry().getLocation().getLat();
        final Double lng = detail.getResult().getGeometry().getLocation().getLng();

        final NearbyPlaces nearbysearch = nearbySearchDao.nearbySearch(types, lat, lng, radius, keywords,
                language, minprice, name, opennow);

        final Set<String> id = nearbysearch.getResults()
                .stream()
                .map(i -> i.getPlaceId())
                .collect(Collectors.toSet());

        return new HashSet<>(detailsDao.getAllPlacesDetails(id));
    }
}
