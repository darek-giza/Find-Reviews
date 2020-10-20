package pl.com.dariusz.giza.FindReviews;

import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.AddressComponent;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Details;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Result;

import java.util.*;

public class TestUtilDetails {

    public static Set<Details> createListDetails() {
        Set<Details> list = new HashSet<>();
        list.add(getPlace1());
        return list;
    }

    public static Details getPlace1() {
        Details placeDetail = new Details();
        placeDetail.setHtmlAttributions(new ArrayList<>());
        placeDetail.setResult(set());
        placeDetail.setStatus("OK");
        return placeDetail;
    }

    public static Result set() {
        Result result = new Result();
        List<AddressComponent> addressComponent = new ArrayList<>();
        result.setAddressComponents(addressComponent);
        result.setFormattedAddress("GryFit, Lubelska 2, 24-100 Puławy, Polska");
        result.setIcon("https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png");
        result.setUrl("https://maps.google.com/?cid=3825745187588198821");
        return result;
    }
}