package pl.com.dariusz.giza.FindReviews.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.com.dariusz.giza.FindReviews.soap.getplace.GetPlaceRequest;
import pl.com.dariusz.giza.FindReviews.soap.getplace.GetPlaceResponse;
import pl.com.dariusz.giza.FindReviews.soap.getplace.Place;

@Endpoint
public class PlaceEndpoint {

    private PlaceService placeService;

    public PlaceEndpoint(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PayloadRoot(namespace = "http://FindReviews.giza.dariusz.com.pl/getPlace", localPart = "getPlaceRequest")
    @ResponsePayload()
    public GetPlaceResponse getPlaceById(@RequestPayload GetPlaceRequest getPlaceRequest) {
        final Place placeById = placeService.getPlace(getPlaceRequest.getId());
        GetPlaceResponse getPlaceResponse = new GetPlaceResponse();
        getPlaceResponse.setPlaces(placeById);
        return  getPlaceResponse;
    }
}
