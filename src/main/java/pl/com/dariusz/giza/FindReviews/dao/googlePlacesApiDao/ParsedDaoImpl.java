package pl.com.dariusz.giza.FindReviews.dao.googlePlacesApiDao;

import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.AddressComponent;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Details;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Review;
import pl.com.dariusz.giza.FindReviews.model.Address;
import pl.com.dariusz.giza.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.model.Reviews;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ParsedDaoImpl implements ParsedDao {

    @Override
    public Set<Places> parse(Set<Details> setDetails) {
        Set<Places> setPlaces = new HashSet<>();
        setDetails.forEach(i -> {
            String placeName = i.getResult().getName();
            String formattedAddress = i.getResult().getFormattedAddress();
            Address address = getAddress(i.getResult().getAddressComponents());
            String phone = i.getResult().getFormattedPhoneNumber();
            String url = i.getResult().getUrl();
            String website = i.getResult().getWebsite();
            String placeId1 = i.getResult().getPlaceId();
            List<String> type = i.getResult().getTypes();
            List<Review> reviews = i.getResult().getReviews();

            if (reviews != null) {
                Double ratingAvg = getRatingAvg(i.getResult().getReviews());
                List<Reviews> listReviews = getListReviews(reviews);
                setPlaces.add(new Places(placeName, formattedAddress, address, phone, url, website, placeId1, type, ratingAvg, listReviews));
            } else {
                setPlaces.add(new Places(placeName, formattedAddress, address, phone, url, website, placeId1, type));
            }
        });
        return setPlaces;
    }

    public List<Reviews> getListReviews(List<Review> reviews) {
        List<Reviews> reviewsList = new ArrayList<>();
        reviews.forEach(r -> {
            String authorName = r.getAuthorName();
            String lang = r.getLanguage();
            Integer rating = r.getRating();
            String relativeTimeDescription = r.getRelativeTimeDescription();
            String text = r.getText();
            Integer time = r.getTime();
            reviewsList.add(new Reviews(authorName, lang, rating, relativeTimeDescription, text, time));
        });
        return reviewsList;
    }

    public Double getRatingAvg(List<Review> reviews) {
        Integer ratingSum = reviews.stream().map(r -> r.getRating()).reduce(Integer::sum).get();
        int count = (int) reviews.stream().map(r -> r.getRating()).count();
        return Double.valueOf(ratingSum / count);
    }

    public Address getAddress(List<AddressComponent> addressComponents) {

        Address address = new Address();
        addressComponents.forEach(a -> {
            String name = a.getLongName();
            a.getTypes().forEach((item) -> {
                if (item.contains("route")) {
                    address.setRoute(name);
                }
                if (item.contains("street_number")) {
                    address.setStreetNumber(name);
                }
                if (item.contains("postal_code")) {
                    address.setPostalCode(name);
                }
                if (item.contains("locality")) {
                    address.setLocality(name);
                }
                if (item.contains("administrative_area_level_1")) {
                    address.setProvince(name);
                }
                if (item.contains("country")) {
                    address.setCountry(name);
                }
            });
        });
        return address;
    }
}

