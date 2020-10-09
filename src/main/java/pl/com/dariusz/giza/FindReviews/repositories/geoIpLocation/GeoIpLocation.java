package pl.com.dariusz.giza.FindReviews.repositories.geoIpLocation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.stereotype.Repository;
import pl.com.dariusz.giza.FindReviews.model.googleApiModels.geolocation.GeoIP;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Repository
public class GeoIpLocation {

    private DatabaseReader dbReader;

    public GeoIP GeoIpLocation(String ip) throws IOException, GeoIp2Exception {
        File database = new File("src/main/resources/GeoLite2-City_20200630/GeoLite2-City.mmdb");

        dbReader = new DatabaseReader.Builder(database).build();

        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);

        String cityName = response.getCity().getName();
        String latitude = response.getLocation().getLatitude().toString();
        String longitude = response.getLocation().getLongitude().toString();
        return new GeoIP(ip, cityName, latitude, longitude);
    }

}
