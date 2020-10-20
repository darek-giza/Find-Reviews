package pl.com.dariusz.giza.FindReviews.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    @SerializedName("route")
    private String route;

    @SerializedName("street_number")
    private String streetNumber;

    @SerializedName("postal_code")
    private String postalCode;

    @SerializedName("locality")
    private String locality;

    @SerializedName("province")
    private String province;

    @SerializedName("country")
    private String country;

    public Address() {
    }
}
