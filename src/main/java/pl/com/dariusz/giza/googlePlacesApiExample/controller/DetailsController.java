package pl.com.dariusz.giza.googlePlacesApiExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.googlePlacesApiExample.model.details.Details;
import pl.com.dariusz.giza.googlePlacesApiExample.service.detailsService.DetailsService;

import java.io.IOException;

@RestController
public class DetailsController {

    private final DetailsService detailsService;

    @Autowired
    public DetailsController(DetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @GetMapping("/details")
    public ResponseEntity<Details> getDetails() throws IOException {
        final Details placeDetails = detailsService.getOne("ChIJtcbU9Lt9IkcR_kdwPUf6yN0");
        if (placeDetails == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(placeDetails, HttpStatus.OK);
    }
}
