package pl.com.dariusz.giza.FindReviews.service;

import pl.com.dariusz.giza.FindReviews.model.Reviews;

import java.util.*;

public interface ReviewService {


    List<Reviews> getReviews(String authorName);
}
