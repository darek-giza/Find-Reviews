package pl.com.dariusz.giza.FindReviews.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDto {

    private String name;

    private String formattedAddress;

    private AddressDto address;

    private String website;

    private Double ratingAvg;

    private List<ReviewDto> reviews = null;
}
