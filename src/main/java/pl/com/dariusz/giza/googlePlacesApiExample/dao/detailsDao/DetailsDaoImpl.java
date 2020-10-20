package pl.com.dariusz.giza.googlePlacesApiExample.dao.detailsDao;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.googlePlacesApiExample.dao.nearbySearchDao.NearbySearchDaoImpl;
import pl.com.dariusz.giza.googlePlacesApiExample.model.details.Details;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class DetailsDaoImpl implements DetailsDao {

    Logger LOGGER = Logger.getLogger(NearbySearchDaoImpl.class.getName());
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

    @Override
    public Set<Details> getAllPlacesDetails(Set<String> id) throws IOException {
     
     Set<Details> allPlacesDetails = new HashSet<>();
        
     for(String i:id){
         final Details detail = getDetails(i);
         allPlacesDetails.add(detail);
     }
     return  allPlacesDetails;
    }
}
