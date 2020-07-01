package pl.com.dariusz.giza.FindReviews;

import org.springframework.web.bind.annotation.GetMapping;
import pl.com.dariusz.giza.FindReviews.model.Example;
import pl.com.dariusz.giza.FindReviews.model.GooMaps;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    GoogleClient googleClient;

    public RestController(GoogleClient googleClient) {
        this.googleClient = googleClient;
    }

    @GetMapping("/nearbysearch")
    public GooMaps nearBySearch() throws IOException {
        return googleClient.nearbysearch("museum", 54.3520500, 18.6463700, 1000, ""
                , "", null, "", null);
    }

    @GetMapping("/search")
    public Example search() throws IOException {
        return googleClient.search("War");
    }
}
