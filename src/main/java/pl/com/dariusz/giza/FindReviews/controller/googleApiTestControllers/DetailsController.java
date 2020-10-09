package pl.com.dariusz.giza.FindReviews.controller.googleApiTestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.model.googleApiModels.details.Details;
import pl.com.dariusz.giza.FindReviews.service.googleApi.details.DetailsService;

import java.io.IOException;

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
