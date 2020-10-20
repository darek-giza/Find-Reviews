package pl.com.dariusz.giza.FindReviews.dao.placesApiDao;

import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Details;
import pl.com.dariusz.giza.FindReviews.model.Places;

import java.util.Set;

public interface ParsedDao {

    Set<Places> parse(Set<Details> setDetails);
}
