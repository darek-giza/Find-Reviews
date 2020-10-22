package pl.com.dariusz.giza.FindReviews.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDto {

    private String language;

    private Integer rating;

    private String relativeTimeDescription;

    private String text;
}
