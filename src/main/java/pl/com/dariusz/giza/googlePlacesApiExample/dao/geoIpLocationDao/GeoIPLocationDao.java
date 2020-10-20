package pl.com.dariusz.giza.googlePlacesApiExample.dao.geoIpLocationDao;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.googlePlacesApiExample.dao.checkIpDao.WhatIsMyIpDao;
import pl.com.dariusz.giza.googlePlacesApiExample.model.geolocation.GeoIP;

import java.io.IOException;

@Service
public class GeoIPLocationDao {

    private final WhatIsMyIpDao whatIsMyIp;
    private final GeoIpDbReaderDao geoIpDbReaderDao;


    public GeoIPLocationDao(WhatIsMyIpDao whatIsMyIp, GeoIpDbReaderDao geoIpDbReaderDao) {
        this.whatIsMyIp = whatIsMyIp;
        this.geoIpDbReaderDao = geoIpDbReaderDao;
    }

    public GeoIP getLocation() throws IOException, GeoIp2Exception {

        final String ip = whatIsMyIp.whatIsMyIp();

        return geoIpDbReaderDao.GeoIpLocation(ip);

    }
}