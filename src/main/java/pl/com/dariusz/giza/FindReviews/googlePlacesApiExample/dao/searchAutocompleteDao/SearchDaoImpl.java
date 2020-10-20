package pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.dao.searchAutocompleteDao;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.searchPlace.Example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

@Service
public class SearchDaoImpl implements SearchDao {

    Logger LOGGER = Logger.getLogger(SearchDaoImpl.class.getName());


    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";

    private static final String TYPE_SEARCH_AUTOCOMPLETE = "/autocomplete";

    private static final String OUT_JSON = "/json";

    private static final String API_KEY = System.getenv("API_KEY");

    private static final String UTF_8 = "utf8";


    @Override
    public Example search(String input) throws IOException {

        if (input == null) {
            throw new IllegalArgumentException("Input value can't be null");
        }

        StringBuilder sb = new StringBuilder(PLACES_API_BASE);
        sb.append(TYPE_SEARCH_AUTOCOMPLETE);
        sb.append(OUT_JSON);
        sb.append("?input=" + URLEncoder.encode(input, StandardCharsets.UTF_8));
        sb.append("&key=" + API_KEY);

        URL url = new URL(sb.toString());
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Example example = new Gson().fromJson(reader,
                Example.class);
        LOGGER.info("Search with autocomplete " + url);
        return example;
    }
}
