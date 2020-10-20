package pl.com.dariusz.giza.FindReviews.dao.googlePlacesApiDao;

import pl.com.dariusz.giza.FindReviews.model.Places;
import pl.com.dariusz.giza.googlePlacesApiExample.model.details.Details;

import java.util.Set;

public interface ParsedDao {

    Set<Places> parse(Set<Details> setDetails);
}
