package pl.com.dariusz.giza.FindReviews.service.details;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.details.Details;
import pl.com.dariusz.giza.FindReviews.service.nearbysearch.NearbySearchServiceImpl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Logger;

@Service
public class DetailsServiceImpl implements DetailsService{

    Logger LOGGER = Logger.getLogger(NearbySearchServiceImpl.class.getName());
    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_SEARCH = "/details";
    private static final String OUT_JSON = "/json";
    private static final String LANGUAGE = "pl";
    private static final String API_KEY = System.getenv("API_KEY");

 @Override
    public Details getDetails(String place_id) throws IOException {
        StringBuilder sb = new StringBuilder(PLACES_API_BASE);
        sb.append(TYPE_SEARCH);
        sb.append(OUT_JSON);
        sb.append("?place_id=" + place_id);
        sb.append("&language=" + LANGUAGE);
        sb.append("&key=" + API_KEY);


        URL url = new URL(sb.toString());
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Details details = new Gson().fromJson(reader,Details.class);
        LOGGER.info("Searching details of place "+ url);
        return details;
    }
}
