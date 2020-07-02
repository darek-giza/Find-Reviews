package pl.com.dariusz.giza.FindReviews.service.searchAutocomplete;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.searchPlace.Example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Logger;

@Service
public class SearchServiceImpl implements SearchService {

    Logger LOGGER = Logger.getLogger(SearchServiceImpl.class.getName());


    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";

    private static final String TYPE_SEARCH_AUTOCOMPLETE = "/autocomplete";

    private static final String OUT_JSON = "/json";

    private static final String API_KEY = System.getenv("API_KEY");

    private static final String UTF_8 = "utf8";


    @Override
    public Example search(String input) throws IOException {

        StringBuilder sb = new StringBuilder(PLACES_API_BASE);
        sb.append(TYPE_SEARCH_AUTOCOMPLETE);
        sb.append(OUT_JSON);
        sb.append("?input=" + URLEncoder.encode(input, UTF_8));
        sb.append("&key=" + API_KEY);

        URL url = new URL(sb.toString());
        InputStreamReader reader = new InputStreamReader(url.openStream());
        pl.com.dariusz.giza.FindReviews.model.searchPlace.Example example = new Gson().fromJson(reader, pl.com.dariusz.giza.FindReviews.model.searchPlace.Example.class);
        LOGGER.info("Search with autocomplete " + url);
        return example;

    }
}
