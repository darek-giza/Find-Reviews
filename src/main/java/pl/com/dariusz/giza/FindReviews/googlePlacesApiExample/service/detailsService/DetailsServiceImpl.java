package pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.service.detailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.dao.detailsDao.DetailsDao;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Details;

import java.io.IOException;
import java.util.Set;

@Service
public class DetailsServiceImpl implements DetailsService {

    private final DetailsDao detailsDao;

    @Autowired
    public DetailsServiceImpl(DetailsDao detailsDao) {
        this.detailsDao = detailsDao;
    }

    @Override
    public Details getOne(String place_id) throws IOException {
        return detailsDao.getDetails(place_id);
    }

    @Override
    public Set<Details> getAll(Set<String> id) throws IOException {
        return null;
    }
}
