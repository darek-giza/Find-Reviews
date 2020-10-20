package pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.service.detailsService;

import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Details;

import java.io.IOException;
import java.util.Set;

public interface DetailsService {

    Details getOne(String place_id) throws IOException;

    Set<Details> getAll(Set<String> id) throws IOException;
}
