package pl.com.dariusz.giza.FindReviews.FindReviews.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Setter
@Getter
public class Places {

    @Id
    private String id;

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

    @SerializedName("rating")
    private Double ratingAvg;

    @SerializedName("reviews")
    private List<Review> reviews = null;

    public Places(String name, String formattedAddress, String formattedPhoneNumber, String url,
                  String website, String placeId, List<String> types,Double ratingAvg, List<Review> reviews) {
        this.name = name;
        this.formattedAddress = formattedAddress;
        this.formattedPhoneNumber = formattedPhoneNumber;
        this.url = url;
        this.website = website;
        this.placeId = placeId;
        this.types = types;
        this.ratingAvg = ratingAvg;
        this.reviews = reviews;
    }

    public Places() {
    }

    public Places(String name, String formattedAddress, String formattedPhoneNumber, String url, String website, String placeId, List<String> types) {
        this.name = name;
        this.formattedAddress = formattedAddress;
        this.formattedPhoneNumber = formattedPhoneNumber;
        this.url = url;
        this.website = website;
        this.placeId = placeId;
        this.types = types;
    }
}