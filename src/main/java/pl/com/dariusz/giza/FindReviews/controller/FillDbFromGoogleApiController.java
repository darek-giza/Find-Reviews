package pl.com.dariusz.giza.FindReviews.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.dao.googlePlacesApiDao.FetchPlacesDao;
import pl.com.dariusz.giza.FindReviews.dao.googlePlacesApiDao.PersistPlacesDao;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Details;
import pl.com.dariusz.giza.FindReviews.model.Places;

import java.io.IOException;
import java.util.Set;

@RestController
public class FillDbFromGoogleApiController {

    private final FetchPlacesDao fetchPlacesDao;
    private final PersistPlacesDao persistPlacesDao;

    @Autowired
    public FillDbFromGoogleApiController(FetchPlacesDao fetchPlacesDao, PersistPlacesDao persistPlacesDao) {
        this.fetchPlacesDao = fetchPlacesDao;
        this.persistPlacesDao = persistPlacesDao;
    }


    @GetMapping("/find")
    public ResponseEntity<Set<Details>> find(@RequestParam String city, @RequestParam String types) throws IOException {
        Preconditions.checkNotNull(city, types);
        final Set<Details> placesDetails = fetchPlacesDao.fetchPlacesDetails(city, types);
        if (placesDetails == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(placesDetails, HttpStatus.OK);
    }
    // types used by Google Places API ( https://developers.google.com/places/supported_types )
    // endpoint gives response from google api


    @GetMapping("/fill-DB")
    public ResponseEntity<Set<Places>> getParsedData(@RequestParam String city, @RequestParam String types) throws IOException {
        Preconditions.checkNotNull(city, types);
        final Set<Places> parsedPlacesDetails = persistPlacesDao.getParsedData(city, types);
        if (parsedPlacesDetails == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
//        persistPlacesDao.save(parsedPlacesDetails);
        return new ResponseEntity<>(parsedPlacesDetails, HttpStatus.OK);
    }
    // endpoint gives response with parsed data and save it in DB
}

