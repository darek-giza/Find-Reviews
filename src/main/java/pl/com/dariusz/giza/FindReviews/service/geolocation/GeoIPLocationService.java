package pl.com.dariusz.giza.FindReviews.service.geolocation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.geolocation.GeoIP;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.logging.Logger;

@Service
public class GeoIPLocationService {

    private DatabaseReader dbReader;

    public String whatIsMyIp() throws IOException {
        URL checkIP = new URL("http://checkip.amazonaws.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(checkIP.openStream()));
        String ip =in.readLine();
        Logger.getLogger("LOG").info("host "+ ip);
        return ip;
    }


    public void GeoIpLocationService() throws IOException {
        File database = new File("src/main/resources/GeoLite2-City_20200630/GeoLite2-City.mmdb");
        dbReader = new DatabaseReader.Builder(database).build();
    }


    public GeoIP getLocation() throws IOException, GeoIp2Exception {

        final String ip = whatIsMyIp();

        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);

        String cityName = response.getCity().getName();
        String latitude = response.getLocation().getLatitude().toString();
        String longitude = response.getLocation().getLongitude().toString();
        return new GeoIP(ip, cityName, latitude, longitude);

    }
}
