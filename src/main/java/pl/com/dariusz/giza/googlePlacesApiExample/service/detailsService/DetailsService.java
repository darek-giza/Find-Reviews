package pl.com.dariusz.giza.googlePlacesApiExample.service.detailsService;

import pl.com.dariusz.giza.googlePlacesApiExample.model.details.Details;

import java.io.IOException;
import java.util.Set;

public interface DetailsService {

    Details getOne(String place_id) throws IOException;

    Set<Details> getAll(Set<String> id) throws IOException;
}
