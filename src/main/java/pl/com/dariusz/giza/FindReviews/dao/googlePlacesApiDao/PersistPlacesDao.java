package pl.com.dariusz.giza.FindReviews.dao.googlePlacesApiDao;

import pl.com.dariusz.giza.FindReviews.model.Places;

import java.io.IOException;
import java.util.Set;

public interface PersistPlacesDao {

    Set<Places> getParsedData(String city, String types) throws IOException;

    void save(Set<Places> placesSet);
}
