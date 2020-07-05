package pl.com.dariusz.giza.FindReviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.model.details.Details;
import pl.com.dariusz.giza.FindReviews.service.details.DetailsService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Logger;

@RestController
public class DetailsController {

    private final DetailsService detailsService;

    @Autowired

    public DetailsController(DetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @GetMapping("/details")
    public Details getDetails() throws IOException{
        return detailsService.getDetails("ChIJtcbU9Lt9IkcR_kdwPUf6yN0");
    }

}
