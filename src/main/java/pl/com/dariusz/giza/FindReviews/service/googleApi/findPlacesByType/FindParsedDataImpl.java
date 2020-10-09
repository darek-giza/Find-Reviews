package pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesByType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.googleApi.details.Details;
import pl.com.dariusz.giza.FindReviews.model.googleApi.details.Review;
import pl.com.dariusz.giza.FindReviews.model.googleApi.detailsDTO.DetailsDTO;
import pl.com.dariusz.giza.FindReviews.model.googleApi.detailsDTO.ReviewDTO;

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
    public Set<DetailsDTO> parse(String city, String types) throws IOException {

        Set<DetailsDTO> detailsDto = new HashSet<>();

        final Set<Details> placesDetails = findService.findPlacesDetails(city, types);

        placesDetails.forEach(i -> {
            String placeName = i.getResult().getName();
            String address = i.getResult().getFormattedAddress();
            String phone = i.getResult().getFormattedPhoneNumber();
            String url = i.getResult().getUrl();
            String website = i.getResult().getWebsite();
            String placeId1 = i.getResult().getPlaceId();
            List<String> type = i.getResult().getTypes();
            List<Review> reviews = i.getResult().getReviews();

            if (reviews != null) {
                List<ReviewDTO> reviewsDto = new ArrayList<>();
                reviews.forEach(r -> {
                    String authorName = r.getAuthorName();
                    String lang = r.getLanguage();
                    Integer rating = r.getRating();
                    String relativeTimeDescription = r.getRelativeTimeDescription();
                    String text = r.getText();
                    Integer time = r.getTime();
                    reviewsDto.add(new ReviewDTO(authorName, lang, rating, relativeTimeDescription, text, time));
                });
                detailsDto.add(new DetailsDTO(placeName, address, phone, url, website, placeId1, type, reviewsDto));
            } else {
                detailsDto.add(new DetailsDTO(placeName, address, phone, url, website, placeId1, type));
            }
        });
        return detailsDto;
    }
}
