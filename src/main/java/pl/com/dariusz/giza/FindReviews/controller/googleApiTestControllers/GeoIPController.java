package pl.com.dariusz.giza.FindReviews.controller.googleApiTestControllers;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.model.googleApi.geolocation.GeoIP;
import pl.com.dariusz.giza.FindReviews.service.googleApi.geolocation.GeoIPLocationService;

import java.io.IOException;

@RestController
public class GeoIPController {

    GeoIPLocationService ipLocationService;

    public GeoIPController(GeoIPLocationService ipLocationService) {
        this.ipLocationService = ipLocationService;
    }

    @GetMapping("/geoIP")
    public GeoIP getLocation() throws IOException, GeoIp2Exception {

        return ipLocationService.getLocation();

    }
}
