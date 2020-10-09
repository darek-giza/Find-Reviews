package pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesByType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.googleApi.details.Details;
import pl.com.dariusz.giza.FindReviews.model.googleApi.detailsDTO.Places;
import pl.com.dariusz.giza.FindReviews.model.googleApi.detailsDTO.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FindParsedDataImpl implements FindParsedData {


    private FindService findService;

    @Autowired
    public FindParsedDataImpl(FindService findService) {
        this.findService = findService;
    }

    @Override
    public Set<Places> parse(String city, String types) throws IOException {

        Set<Places> detailsDto = new HashSet<>();

        final Set<Details> placesDetails = findService.findPlacesDetails(city, types);

        placesDetails.forEach(i -> {
            String placeName = i.getResult().getName();
            String address = i.getResult().getFormattedAddress();
            String phone = i.getResult().getFormattedPhoneNumber();
            String url = i.getResult().getUrl();
            String website = i.getResult().getWebsite();
            String placeId1 = i.getResult().getPlaceId();
            List<String> type = i.getResult().getTypes();
            List<pl.com.dariusz.giza.FindReviews.model.googleApi.details.Review> reviews = i.getResult().getReviews();

            if (reviews != null) {
                List<Review> reviewsDto = new ArrayList<>();
                reviews.forEach(r -> {
                    String authorName = r.getAuthorName();
                    String lang = r.getLanguage();
                    Integer rating = r.getRating();
                    String relativeTimeDescription = r.getRelativeTimeDescription();
                    String text = r.getText();
                    Integer time = r.getTime();
                    reviewsDto.add(new Review(authorName, lang, rating, relativeTimeDescription, text, time));
                });
                detailsDto.add(new Places(placeName, address, phone, url, website, placeId1, type, reviewsDto));
            } else {
                detailsDto.add(new Places(placeName, address, phone, url, website, placeId1, type));
            }
        });
        return detailsDto;
    }
}
