package pl.com.dariusz.giza.FindReviews.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.com.dariusz.giza.FindReviews.model.geolocation.GeoIP;
import pl.com.dariusz.giza.FindReviews.model.nearbySearch.NearbyPlaces;
import pl.com.dariusz.giza.FindReviews.service.geolocation.GeoIPLocationService;
import pl.com.dariusz.giza.FindReviews.service.nearbysearch.NearbySearchService;

import java.io.IOException;

@RestController
@CrossOrigin
@EnableWebMvc
public class NearbySearchController {

    private final NearbySearchService nearBySearchService;
    private final GeoIPLocationService locationService;

    @Autowired
    public NearbySearchController(NearbySearchService nearBySearchService, GeoIPLocationService locationService) {
        this.nearBySearchService = nearBySearchService;
        this.locationService = locationService;
    }

    @GetMapping("/api/nearbysearch")
    public NearbyPlaces nearBySearch(
            @RequestParam String types,@RequestParam Integer radius,@RequestParam String keywords,
            @RequestParam String language,@RequestParam Integer minprice,@RequestParam String name,
            @RequestParam Boolean opennow) throws IOException, GeoIp2Exception {

        locationService.getLocation();
        final GeoIP location = locationService.getLocation();
        final Double latitude = Double.valueOf(location.getLatitude());
        final Double longitude = Double.valueOf(location.getLongitude());

        return nearBySearchService.nearbysearch(types, latitude, longitude, radius,
                keywords,language,minprice,name,opennow);
    }
}
