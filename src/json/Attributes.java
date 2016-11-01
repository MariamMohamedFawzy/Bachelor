
package json;

import java.io.Serializable;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Attributes implements Serializable {

    @SerializedName("Take-out")
    @Expose
    private Boolean takeOut;
    @SerializedName("Drive-Thru")
    @Expose
    private Boolean driveThru;
    @SerializedName("Good For")
    @Expose
    private GoodFor goodFor;
    @SerializedName("Caters")
    @Expose
    private Boolean caters;
    @SerializedName("Noise Level")
    @Expose
    private String noiseLevel;
    @SerializedName("Takes Reservations")
    @Expose
    private Boolean takesReservations;
    @SerializedName("Delivery")
    @Expose
    private Boolean delivery;
    @SerializedName("Ambience")
    @Expose
    private Ambience ambience;
    @SerializedName("Parking")
    @Expose
    private Parking parking;
    @SerializedName("Has TV")
    @Expose
    private Boolean hasTV;
    @SerializedName("Outdoor Seating")
    @Expose
    private Boolean outdoorSeating;
    @SerializedName("Attire")
    @Expose
    private String attire;
    @SerializedName("Alcohol")
    @Expose
    private String alcohol;
    @SerializedName("Waiter Service")
    @Expose
    private Boolean waiterService;
    @SerializedName("Accepts Credit Cards")
    @Expose
    private Boolean acceptsCreditCards;
    @SerializedName("Good for Kids")
    @Expose
    private Boolean goodForKids;
    @SerializedName("Good For Groups")
    @Expose
    private Boolean goodForGroups;
    @SerializedName("Price Range")
    @Expose
    private Integer priceRange;

    /**
     * 
     * @return
     *     The takeOut
     */
    public Boolean getTakeOut() {
        return takeOut;
    }

    /**
     * 
     * @param takeOut
     *     The Take-out
     */
    public void setTakeOut(Boolean takeOut) {
        this.takeOut = takeOut;
    }

    /**
     * 
     * @return
     *     The driveThru
     */
    public Boolean getDriveThru() {
        return driveThru;
    }

    /**
     * 
     * @param driveThru
     *     The Drive-Thru
     */
    public void setDriveThru(Boolean driveThru) {
        this.driveThru = driveThru;
    }

    /**
     * 
     * @return
     *     The goodFor
     */
    public GoodFor getGoodFor() {
        return goodFor;
    }

    /**
     * 
     * @param goodFor
     *     The Good For
     */
    public void setGoodFor(GoodFor goodFor) {
        this.goodFor = goodFor;
    }

    /**
     * 
     * @return
     *     The caters
     */
    public Boolean getCaters() {
        return caters;
    }

    /**
     * 
     * @param caters
     *     The Caters
     */
    public void setCaters(Boolean caters) {
        this.caters = caters;
    }

    /**
     * 
     * @return
     *     The noiseLevel
     */
    public String getNoiseLevel() {
        return noiseLevel;
    }

    /**
     * 
     * @param noiseLevel
     *     The Noise Level
     */
    public void setNoiseLevel(String noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    /**
     * 
     * @return
     *     The takesReservations
     */
    public Boolean getTakesReservations() {
        return takesReservations;
    }

    /**
     * 
     * @param takesReservations
     *     The Takes Reservations
     */
    public void setTakesReservations(Boolean takesReservations) {
        this.takesReservations = takesReservations;
    }

    /**
     * 
     * @return
     *     The delivery
     */
    public Boolean getDelivery() {
        return delivery;
    }

    /**
     * 
     * @param delivery
     *     The Delivery
     */
    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    /**
     * 
     * @return
     *     The ambience
     */
    public Ambience getAmbience() {
        return ambience;
    }

    /**
     * 
     * @param ambience
     *     The Ambience
     */
    public void setAmbience(Ambience ambience) {
        this.ambience = ambience;
    }

    /**
     * 
     * @return
     *     The parking
     */
    public Parking getParking() {
        return parking;
    }

    /**
     * 
     * @param parking
     *     The Parking
     */
    public void setParking(Parking parking) {
        this.parking = parking;
    }

    /**
     * 
     * @return
     *     The hasTV
     */
    public Boolean getHasTV() {
        return hasTV;
    }

    /**
     * 
     * @param hasTV
     *     The Has TV
     */
    public void setHasTV(Boolean hasTV) {
        this.hasTV = hasTV;
    }

    /**
     * 
     * @return
     *     The outdoorSeating
     */
    public Boolean getOutdoorSeating() {
        return outdoorSeating;
    }

    /**
     * 
     * @param outdoorSeating
     *     The Outdoor Seating
     */
    public void setOutdoorSeating(Boolean outdoorSeating) {
        this.outdoorSeating = outdoorSeating;
    }

    /**
     * 
     * @return
     *     The attire
     */
    public String getAttire() {
        return attire;
    }

    /**
     * 
     * @param attire
     *     The Attire
     */
    public void setAttire(String attire) {
        this.attire = attire;
    }

    /**
     * 
     * @return
     *     The alcohol
     */
    public String getAlcohol() {
        return alcohol;
    }

    /**
     * 
     * @param alcohol
     *     The Alcohol
     */
    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    /**
     * 
     * @return
     *     The waiterService
     */
    public Boolean getWaiterService() {
        return waiterService;
    }

    /**
     * 
     * @param waiterService
     *     The Waiter Service
     */
    public void setWaiterService(Boolean waiterService) {
        this.waiterService = waiterService;
    }

    /**
     * 
     * @return
     *     The acceptsCreditCards
     */
    public Boolean getAcceptsCreditCards() {
        return acceptsCreditCards;
    }

    /**
     * 
     * @param acceptsCreditCards
     *     The Accepts Credit Cards
     */
    public void setAcceptsCreditCards(Boolean acceptsCreditCards) {
        this.acceptsCreditCards = acceptsCreditCards;
    }

    /**
     * 
     * @return
     *     The goodForKids
     */
    public Boolean getGoodForKids() {
        return goodForKids;
    }

    /**
     * 
     * @param goodForKids
     *     The Good for Kids
     */
    public void setGoodForKids(Boolean goodForKids) {
        this.goodForKids = goodForKids;
    }

    /**
     * 
     * @return
     *     The goodForGroups
     */
    public Boolean getGoodForGroups() {
        return goodForGroups;
    }

    /**
     * 
     * @param goodForGroups
     *     The Good For Groups
     */
    public void setGoodForGroups(Boolean goodForGroups) {
        this.goodForGroups = goodForGroups;
    }

    /**
     * 
     * @return
     *     The priceRange
     */
    public Integer getPriceRange() {
        return priceRange;
    }

    /**
     * 
     * @param priceRange
     *     The Price Range
     */
    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }

}
