
package json;

import java.io.Serializable;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Parking implements Serializable {

    @SerializedName("garage")
    @Expose
    private Boolean garage;
    @SerializedName("street")
    @Expose
    private Boolean street;
    @SerializedName("validated")
    @Expose
    private Boolean validated;
    @SerializedName("lot")
    @Expose
    private Boolean lot;
    @SerializedName("valet")
    @Expose
    private Boolean valet;

    /**
     * 
     * @return
     *     The garage
     */
    public Boolean getGarage() {
        return garage;
    }

    /**
     * 
     * @param garage
     *     The garage
     */
    public void setGarage(Boolean garage) {
        this.garage = garage;
    }

    /**
     * 
     * @return
     *     The street
     */
    public Boolean getStreet() {
        return street;
    }

    /**
     * 
     * @param street
     *     The street
     */
    public void setStreet(Boolean street) {
        this.street = street;
    }

    /**
     * 
     * @return
     *     The validated
     */
    public Boolean getValidated() {
        return validated;
    }

    /**
     * 
     * @param validated
     *     The validated
     */
    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    /**
     * 
     * @return
     *     The lot
     */
    public Boolean getLot() {
        return lot;
    }

    /**
     * 
     * @param lot
     *     The lot
     */
    public void setLot(Boolean lot) {
        this.lot = lot;
    }

    /**
     * 
     * @return
     *     The valet
     */
    public Boolean getValet() {
        return valet;
    }

    /**
     * 
     * @param valet
     *     The valet
     */
    public void setValet(Boolean valet) {
        this.valet = valet;
    }

}
