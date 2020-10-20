package pl.com.dariusz.giza.googlePlacesApiExample.dao.detailsDao;

import pl.com.dariusz.giza.googlePlacesApiExample.model.details.Details;

import java.io.IOException;
import java.util.Set;

public interface DetailsDao {

    Details getDetails(String place_id) throws IOException;

    Set<Details> getAllPlacesDetails(Set<String> id) throws IOException;
}
