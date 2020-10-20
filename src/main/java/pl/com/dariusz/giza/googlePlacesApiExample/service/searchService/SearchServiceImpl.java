package pl.com.dariusz.giza.googlePlacesApiExample.service.searchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.googlePlacesApiExample.dao.searchAutocompleteDao.SearchDao;
import pl.com.dariusz.giza.googlePlacesApiExample.model.searchPlace.Example;

import java.io.IOException;

@Service
public class SearchServiceImpl implements SearchService {

    private  final SearchDao searchDao;

    @Autowired
    public SearchServiceImpl(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    @Override
    public Example get(String input) throws IOException {
        return searchDao.search(input);
    }
}
