package pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.service.geoIpService;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.geolocation.GeoIP;

import java.io.IOException;

public interface GeoIpService {

    GeoIP getLocation() throws IOException, GeoIp2Exception;
}
