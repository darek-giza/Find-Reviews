package pl.com.dariusz.giza.googlePlacesApiExample.service.geoIpService;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.googlePlacesApiExample.dao.geoIpLocationDao.GeoIPLocationDao;
import pl.com.dariusz.giza.googlePlacesApiExample.model.geolocation.GeoIP;

import java.io.IOException;

@Service
public class GeoIpServiceImpl implements GeoIpService {

    private final GeoIPLocationDao geoIPLocationDao;

    @Autowired
    public GeoIpServiceImpl(GeoIPLocationDao geoIPLocationDao) {
        this.geoIPLocationDao = geoIPLocationDao;
    }

    @Override
    public GeoIP getLocation() throws IOException, GeoIp2Exception {
        return geoIPLocationDao.getLocation();
    }
}
