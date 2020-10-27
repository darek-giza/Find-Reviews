package pl.com.dariusz.giza.FindReviews.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    @SerializedName("nick")
    private String nick;

    @SerializedName("locality")
    private String locality;

    @SerializedName("route")
    private String route;

    @SerializedName("street_number")
    private Integer streetNumber;
}
