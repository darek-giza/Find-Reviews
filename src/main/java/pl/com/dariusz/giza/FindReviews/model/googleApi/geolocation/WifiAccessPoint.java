
package pl.com.dariusz.giza.FindReviews.model.googleApi.geolocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WifiAccessPoint {

    @SerializedName("macAddress")
    @Expose
    private String macAddress;
    @SerializedName("signalStrength")
    @Expose
    private Integer signalStrength;
    @SerializedName("signalToNoiseRatio")
    @Expose
    private Integer signalToNoiseRatio;

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Integer getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(Integer signalStrength) {
        this.signalStrength = signalStrength;
    }

    public Integer getSignalToNoiseRatio() {
        return signalToNoiseRatio;
    }

    public void setSignalToNoiseRatio(Integer signalToNoiseRatio) {
        this.signalToNoiseRatio = signalToNoiseRatio;
    }

}
