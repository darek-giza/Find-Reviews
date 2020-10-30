package pl.com.dariusz.giza.FindReviews.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.model.Reviews;
import pl.com.dariusz.giza.FindReviews.service.ReviewService;

import java.util.*;

@RestController
@RequestMapping(ReviewController.BASE_URL)
public class ReviewController {

    public static final String BASE_URL = "/api";

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("getByAuthorName")
    public ResponseEntity<List<Reviews>> getByAuthor(@RequestParam String authorName) {
        final List<Reviews> reviews = reviewService.getReviews(authorName);
        if (reviews == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
