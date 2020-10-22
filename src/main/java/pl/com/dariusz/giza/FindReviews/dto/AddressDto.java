package pl.com.dariusz.giza.FindReviews.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private String route;

    private String streetNumber;

    private String postalCode;

    private String locality;

    private String province;

    private String country;
}
