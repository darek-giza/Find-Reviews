package pl.com.dariusz.giza.FindReviews.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "placeDto",propOrder = {
        "name",
        "formattedAddress",
        "address",
        "website",
        "ratingAvg",
        "reviews"
},namespace = "http://FindReviews.giza.dariusz.com.pl/getPlaceDto")
public class PlaceDto {

    private String name;

    private String formattedAddress;

    private AddressDto address;

    private String website;

    private Double ratingAvg;

    private List<ReviewDto> reviews = null;
}
