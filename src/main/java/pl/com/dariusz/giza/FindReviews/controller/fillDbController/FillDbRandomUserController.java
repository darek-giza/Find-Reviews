package pl.com.dariusz.giza.FindReviews.controller.fillDbController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.model.User;
import pl.com.dariusz.giza.FindReviews.service.userUtilsService.CreateRandomUserService;
import pl.com.dariusz.giza.FindReviews.service.userUtilsService.UserUtilDataService;

import java.util.List;

@RestController
@RequestMapping(FillDbRandomUserController.BASE_URL)
public class FillDbRandomUserController {

    public static final String BASE_URL = "/api";

    private CreateRandomUserService createRandomUserService;
    private UserUtilDataService utilDataService;

    @Autowired
    public FillDbRandomUserController(CreateRandomUserService createRandomUserService, UserUtilDataService utilDataService) {
        this.createRandomUserService = createRandomUserService;
        this.utilDataService = utilDataService;
    }

    @GetMapping("generateRandomUser")
    public ResponseEntity<List<User>> createAndSave() {
        final List<String> listAuthorNames = createRandomUserService.getListAuthorName();
        final List<User> users = utilDataService.createUsers(listAuthorNames);
        createRandomUserService.saveRandomUsers(users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
