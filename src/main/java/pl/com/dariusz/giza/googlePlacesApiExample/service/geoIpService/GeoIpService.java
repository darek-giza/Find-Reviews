package pl.com.dariusz.giza.googlePlacesApiExample.service.geoIpService;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import pl.com.dariusz.giza.googlePlacesApiExample.model.geolocation.GeoIP;

import java.io.IOException;

public interface GeoIpService {

    GeoIP getLocation() throws IOException, GeoIp2Exception;
}
