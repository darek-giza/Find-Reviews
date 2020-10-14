package pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.googleApiModels.details.Details;
import pl.com.dariusz.giza.FindReviews.model.places.Places;
import pl.com.dariusz.giza.FindReviews.model.places.Review;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FindParsedDataServiceImpl implements FindParsedDataService {


    private FindService findService;
    private PlacesRepository placesRepository;

    @Autowired
    public FindParsedDataServiceImpl(FindService findService, PlacesRepository placesRepository) {
        this.findService = findService;
        this.placesRepository = placesRepository;
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
            List<pl.com.dariusz.giza.FindReviews.model.googleApiModels.details.Review> reviews = i.getResult().getReviews();

            if (reviews != null) {
                List<Review> reviewsDto = new ArrayList<>();

                Integer ratingSum = i.getResult().getReviews()
                        .stream()
                        .map(r -> r.getRating())
                        .reduce(Integer::sum).get();
                int count = (int) i.getResult().getReviews().stream().map(r -> r.getRating()).count();
                Double ratingAvg = Double.valueOf(ratingSum / count);

                reviews.forEach(r -> {
                    String authorName = r.getAuthorName();
                    String lang = r.getLanguage();
                    Integer rating = r.getRating();
                    String relativeTimeDescription = r.getRelativeTimeDescription();
                    String text = r.getText();
                    Integer time = r.getTime();
                    reviewsDto.add(new Review(authorName, lang, rating, relativeTimeDescription, text, time));
                });
                detailsDto.add(new Places(placeName, address, phone, url, website, placeId1, type, ratingAvg, reviewsDto));
            } else {
                detailsDto.add(new Places(placeName, address, phone, url, website, placeId1, type));
            }
        });
        return detailsDto;
    }

    @Override
    public void save(Set<Places> placesSet) {
        placesRepository.saveAll(placesSet);
    }

}
