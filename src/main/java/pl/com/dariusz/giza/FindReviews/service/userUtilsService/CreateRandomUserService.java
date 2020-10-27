package pl.com.dariusz.giza.FindReviews.service.userUtilsService;

import pl.com.dariusz.giza.FindReviews.model.User;

import java.util.List;

public interface CreateRandomUserService {

    List<String> getListAuthorName();

    void saveRandomUsers(List<User> users);
}