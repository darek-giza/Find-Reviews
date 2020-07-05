package pl.com.dariusz.giza.FindReviews.service.geolocation;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.geolocation.GeoIP;
import pl.com.dariusz.giza.FindReviews.repositories.GeoIpLocation;
import pl.com.dariusz.giza.FindReviews.service.checkIp.WhatIsMyIpService;

import java.io.IOException;

@Service
public class GeoIPLocationService {

    private WhatIsMyIpService whatIsMyIp;
    private GeoIpLocation geoIpLocation;


    public GeoIPLocationService(WhatIsMyIpService whatIsMyIp, GeoIpLocation geoIpLocation) {
        this.whatIsMyIp = whatIsMyIp;
        this.geoIpLocation = geoIpLocation;
    }

    public GeoIP getLocation() throws IOException, GeoIp2Exception {

        final String ip = whatIsMyIp.whatIsMyIp();

        return geoIpLocation.GeoIpLocation(ip);

    }
}
