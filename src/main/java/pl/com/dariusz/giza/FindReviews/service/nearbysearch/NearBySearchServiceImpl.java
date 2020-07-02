package pl.com.dariusz.giza.FindReviews.service.nearbysearch;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.nearBySearch.Example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Logger;

@Service
public class NearBySearchServiceImpl implements NearBySearchService {

    Logger LOGGER = Logger.getLogger(NearBySearchServiceImpl.class.getName());
    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_SEARCH = "/nearbysearch";
    private static final String OUT_JSON = "/json";
    private static final String UTF_8 = "utf8";
    private static final String API_KEY = System.getenv("API_KEY");


    @Override
    public Example nearbysearch(String types, double lat, double lng, int radius, String keywords,
                                String language, Integer minprice, String name, Boolean opennow) throws IOException {

        StringBuilder sb = new StringBuilder(PLACES_API_BASE);
        sb.append(TYPE_SEARCH);
        sb.append(OUT_JSON);
        sb.append("?location=" + String.valueOf(lat) + "," + String.valueOf(lng));
        sb.append("&radius=" + String.valueOf(radius));
        sb.append("&type=" + URLEncoder.encode(types, UTF_8));
        sb.append("&keywords=" + keywords);
        sb.append("&language=" + language);
        sb.append("&minprice=" + minprice);
        sb.append("&name" + name);
//        sb.append("&opennow="+opennow);
        sb.append("&key=" + API_KEY);

        URL url = new URL(sb.toString());
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Example example = new Gson().fromJson(reader, Example.class);
        LOGGER.info("Searching nearBySearch " + url);
        return example;
    }
}

