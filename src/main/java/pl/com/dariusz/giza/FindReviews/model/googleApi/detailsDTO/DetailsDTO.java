package pl.com.dariusz.giza.FindReviews.model.googleApi.detailsDTO;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DetailsDTO {

    @SerializedName("name")
    private String name;

    @SerializedName("places_id")
    private String placeId;

    public DetailsDTO(String name, String placeId) {
        this.name = name;
        this.placeId = placeId;
    }

    public DetailsDTO() {
    }
}
