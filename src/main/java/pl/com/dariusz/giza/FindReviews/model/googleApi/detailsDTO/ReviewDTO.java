package pl.com.dariusz.giza.FindReviews.model.googleApi.detailsDTO;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {

    @SerializedName("author_name")
    private String authorName;

    @SerializedName("language")
    private String language;

    @SerializedName("rating")
    private Integer rating;

    @SerializedName("relativeTimeDescription")
    private String relativeTimeDescription;

    @SerializedName("text")
    private String text;

    @SerializedName("time")
    private Integer time;

    public ReviewDTO() {
    }

    public ReviewDTO(String authorName, String language, Integer rating, String relativeTimeDescription, String text, Integer time) {
        this.authorName = authorName;
        this.language = language;
        this.rating = rating;
        this.relativeTimeDescription = relativeTimeDescription;
        this.text = text;
        this.time = time;
    }
}
