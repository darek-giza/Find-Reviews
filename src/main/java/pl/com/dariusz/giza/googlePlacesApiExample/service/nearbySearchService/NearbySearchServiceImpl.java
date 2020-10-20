package pl.com.dariusz.giza.googlePlacesApiExample.service.nearbySearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.googlePlacesApiExample.dao.nearbySearchDao.NearbySearchDao;
import pl.com.dariusz.giza.googlePlacesApiExample.model.nearbySearch.NearbyPlaces;

import java.io.IOException;

@Service
public class NearbySearchServiceImpl implements NearbySearchService {

    private final NearbySearchDao nearbySearchDao;

    @Autowired
    public NearbySearchServiceImpl(NearbySearchDao nearbySearchDao) {
        this.nearbySearchDao = nearbySearchDao;
    }

    @Override
    public NearbyPlaces search(String types, Double latitude, Double longitude, Integer radius, String keywords,
                               String language, Integer minprice, String name, Boolean opennow) throws IOException {
        return nearbySearchDao.nearbySearch(types, latitude, longitude, radius,
                keywords,language,minprice,name,opennow);
    }
}
