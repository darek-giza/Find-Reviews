package pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.geolocation.GeoIP;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.nearbySearch.NearbyPlaces;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.service.geoIpService.GeoIpService;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.service.nearbySearchService.NearbySearchService;

import java.io.IOException;

@RestController
@CrossOrigin
@EnableWebMvc
public class NearbySearchController {

    private final NearbySearchService nearbySearchService;
    private final GeoIpService geoIpService;

    @Autowired
    public NearbySearchController(NearbySearchService nearbySearchService, GeoIpService geoIpService) {
        this.nearbySearchService = nearbySearchService;
        this.geoIpService = geoIpService;
    }

    @GetMapping("/api/nearbysearch")
    public ResponseEntity<NearbyPlaces> nearBySearch(
            @RequestParam String types, @RequestParam Integer radius, @RequestParam String keywords,
            @RequestParam String language, @RequestParam Integer minprice, @RequestParam String name,
            @RequestParam Boolean opennow) throws IOException, GeoIp2Exception {

        final GeoIP location = geoIpService.getLocation();
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        final Double latitude = Double.valueOf(location.getLatitude());
        final Double longitude = Double.valueOf(location.getLongitude());

        final NearbyPlaces nearbyPlaces = nearbySearchService.search(types, latitude, longitude, radius, keywords, language,
                minprice, name, opennow);
        if (nearbyPlaces == null) {
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(nearbyPlaces, HttpStatus.OK);
    }
}
