package pl.com.dariusz.giza.FindReviews.service;

import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserUtilDataServiceImpl implements UserUtilDataService {

    public List<User> createUsers(List<String> listAuthorNames) {
        List<User> listUser = new ArrayList<>();
        listAuthorNames.forEach(a -> {
            final String nick = String.copyValueOf(a.toCharArray());
            User user = new User();
            user.setNick(nick);
            user.setLocality(getRandomLocality());
            user.setRoute(getRandomRoute());
            user.setStreetNumber(getRandomStreetNumber());
            listUser.add(user);

        });
        return listUser;
    }

    public String getRandomLocality() {
        List<String> locality = new ArrayList<>();
        locality.add("Warszawa");
        locality.add("Lublin");
        locality.add("Kraków");
        locality.add("Łódź");
        locality.add("Gdańsk");
        locality.add("Gdynia");
        locality.add("Puławy");
        locality.add("Katowice");
        Collections.shuffle(locality);
        return locality.stream().findFirst().get();
    }

    public String getRandomRoute() {
        List<String> route = new ArrayList();
        route.add("Mickiewicza");
        route.add("Sienkiewicza");
        route.add("Żeromskiego");
        route.add("Kowalska");
        route.add("Malarska");
        route.add("Jana Pawła");
        route.add("Jasińskiego");
        route.add("Kotarasińskiego");
        route.add("Chrobrego");
        Collections.shuffle(route);
        return route.stream().findFirst().get();
    }

    public int getRandomStreetNumber() {
        return 1 + (int) (Math.random() * 100);

    }
}
