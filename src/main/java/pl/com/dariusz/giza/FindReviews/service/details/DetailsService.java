package pl.com.dariusz.giza.FindReviews.service.details;

import pl.com.dariusz.giza.FindReviews.model.details.Details;

import java.io.IOException;

public interface DetailsService {

    Details getDetails(String place_id) throws IOException;
}
