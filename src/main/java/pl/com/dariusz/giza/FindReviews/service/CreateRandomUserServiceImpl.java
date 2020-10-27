package pl.com.dariusz.giza.FindReviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.model.Reviews;
import pl.com.dariusz.giza.FindReviews.model.User;
import pl.com.dariusz.giza.FindReviews.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateRandomUserServiceImpl implements CreateRandomUserService {

    private PlacesService placesService;
    private UserRepository userRepository;

    @Autowired
    public CreateRandomUserServiceImpl(PlacesService placesService, UserRepository userRepository) {
        this.placesService = placesService;
        this.userRepository = userRepository;
    }

    @Override
    public List<String> getListAuthorName() {
        final List<Places> allPlaces = placesService.getAll();
        List<String> listAuthorNames = new ArrayList<>();
        allPlaces.forEach(places -> {
            final List<Reviews> reviews = places.getReviews();
            if (reviews != null) {
                places.getReviews().forEach(r -> {
                    if (r != null) {
                        final String name = r.getAuthorName();
                        if (name != null) {
                            listAuthorNames.add(name);
                        }
                    }
                });
            }
        });
        return listAuthorNames;
    }

    @Override
    public void saveRandomUsers(List<User> users) {
        userRepository.saveAll(users);
    }
}