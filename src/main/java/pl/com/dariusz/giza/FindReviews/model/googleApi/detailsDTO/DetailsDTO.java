package pl.com.dariusz.giza.FindReviews.model.googleApi.detailsDTO;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class DetailsDTO {

    @SerializedName("name")
    private String name;

    @SerializedName("formatted_address")
    private String formattedAddress;

    @SerializedName("formatted_phone_number")
    private String formattedPhoneNumber;

    @SerializedName("url")
    private String url;

    @SerializedName("website")
    private String website;

    @SerializedName("places_id")
    private String placeId;

    @SerializedName("types")
    private List<String> types = null;

    @SerializedName("reviews")
    private List<ReviewDTO> reviews = null;

    public DetailsDTO(String name, String formattedAddress, String formattedPhoneNumber, String url,
                      String website, String placeId, List<String> types, List<ReviewDTO> reviews) {
        this.name = name;
        this.formattedAddress = formattedAddress;
        this.formattedPhoneNumber = formattedPhoneNumber;
        this.url = url;
        this.website = website;
        this.placeId = placeId;
        this.types = types;
        this.reviews = reviews;
    }

    public DetailsDTO() {
    }

    public DetailsDTO(String name, String formattedAddress, String formattedPhoneNumber, String url, String website, String placeId, List<String> types) {
        this.name = name;
        this.formattedAddress = formattedAddress;
        this.formattedPhoneNumber = formattedPhoneNumber;
        this.url = url;
        this.website = website;
        this.placeId = placeId;
        this.types = types;
    }
}
