package pl.com.dariusz.giza.FindReviews.service.googleApi.geolocation;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.googleApi.geolocation.GeoIP;
import pl.com.dariusz.giza.FindReviews.repositories.geoIpLocation.GeoIpLocation;
import pl.com.dariusz.giza.FindReviews.service.googleApi.checkIp.WhatIsMyIpService;

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