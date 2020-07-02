
package pl.com.dariusz.giza.FindReviews.model.geolocation;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("considerIp")
    @Expose
    private String considerIp;
    @SerializedName("wifiAccessPoints")
    @Expose
    private List<WifiAccessPoint> wifiAccessPoints = null;

    public String getConsiderIp() {
        return considerIp;
    }

    public void setConsiderIp(String considerIp) {
        this.considerIp = considerIp;
    }

    public List<WifiAccessPoint> getWifiAccessPoints() {
        return wifiAccessPoints;
    }

    public void setWifiAccessPoints(List<WifiAccessPoint> wifiAccessPoints) {
        this.wifiAccessPoints = wifiAccessPoints;
    }

}
