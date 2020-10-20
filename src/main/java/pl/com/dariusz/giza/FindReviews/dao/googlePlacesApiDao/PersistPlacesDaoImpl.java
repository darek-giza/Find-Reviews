package pl.com.dariusz.giza.FindReviews.dao.googlePlacesApiDao;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Details;
import pl.com.dariusz.giza.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;

import java.io.IOException;
import java.util.Set;

@Service
public class PersistPlacesDaoImpl implements PersistPlacesDao {


    private final FetchPlacesDao fetchPlacesDao;
    private PlacesRepository placesRepository;
    private final ParsedDao parsedDao;

    @Autowired
    public PersistPlacesDaoImpl(FetchPlacesDao fetchPlacesDao, PlacesRepository placesRepository, ParsedDao parsedDao) {
        this.fetchPlacesDao = fetchPlacesDao;
        this.placesRepository = placesRepository;
        this.parsedDao = parsedDao;
    }

    @Override
    public Set<Places> getParsedData(String city, String types) throws IOException {
        Preconditions.checkNotNull(city, "Arguments can't be null value", 1);
        Preconditions.checkNotNull(types, "Arguments can't be null value", 2);
        final Set<Details> placesDetails = fetchPlacesDao.fetchPlacesDetails(city, types);
        Preconditions.checkNotNull(placesDetails, "List places is empty");
        return parsedDao.parse(placesDetails);


    }

    @Override
    public void save(Set<Places> placesSet) {
        placesRepository.saveAll(placesSet);
    }

}

