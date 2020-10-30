package pl.com.dariusz.giza.FindReviews.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reviewDto",propOrder = {
        "language",
        "rating",
        "relativeTimeDescription",
        "text"
},namespace ="http://FindReviews.giza.dariusz.com.pl/getPlaceDto")
public class ReviewDto {

    private String language;

    private Integer rating;

    private String relativeTimeDescription;

    private String text;
}
