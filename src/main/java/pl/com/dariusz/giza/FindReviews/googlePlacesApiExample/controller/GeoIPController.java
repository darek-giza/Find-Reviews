package pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.service.geoIpService.GeoIpService;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.geolocation.GeoIP;

import java.io.IOException;

@RestController
public class GeoIPController {

    private final GeoIpService geoIpService;

    @Autowired
    public GeoIPController(GeoIpService geoIpService) {
        this.geoIpService = geoIpService;
    }

    @GetMapping("/geoIP")
    public ResponseEntity<GeoIP> getLocation() throws IOException, GeoIp2Exception {
        final GeoIP location = geoIpService.getLocation();
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }
}
