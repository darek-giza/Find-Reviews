package pl.com.dariusz.giza.FindReviews.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressDto",propOrder = {
        "route",
        "streetNumber",
        "postalCode",
        "locality",
        "province",
        "country"
},namespace = "http://FindReviews.giza.dariusz.com.pl/getPlaceDto")
public class AddressDto {

    private String route;

    private String streetNumber;

    private String postalCode;

    private String locality;

    private String province;

    private String country;
}
