
package json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Business implements Serializable {

    @SerializedName("business_id")
    @Expose
    private String businessId;
    @SerializedName("full_address")
    @Expose
    private String fullAddress;
    @SerializedName("hours")
    @Expose
    private Hours hours;
    @SerializedName("open")
    @Expose
    private Boolean open;
    @SerializedName("categories")
    @Expose
    private List<String> categories = new ArrayList<String>();
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("review_count")
    @Expose
    private Integer reviewCount;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("neighborhoods")
    @Expose
    private List<Object> neighborhoods = new ArrayList<Object>();
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("stars")
    @Expose
    private Double stars;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("type")
    @Expose
    private String type;
    
//    private int id;
//    
//    public int getId() {
//    	return this.id;
//    }
//    
//    public void setId(int id) {
//    	this.id = id;
//    }

    /**
     * 
     * @return
     *     The businessId
     */
    public String getBusinessId() {
        return businessId;
    }

    /**
     * 
     * @param businessId
     *     The business_id
     */
    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    /**
     * 
     * @return
     *     The fullAddress
     */
    public String getFullAddress() {
        return fullAddress;
    }

    /**
     * 
     * @param fullAddress
     *     The full_address
     */
    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    /**
     * 
     * @return
     *     The hours
     */
    public Hours getHours() {
        return hours;
    }

    /**
     * 
     * @param hours
     *     The hours
     */
    public void setHours(Hours hours) {
        this.hours = hours;
    }

    /**
     * 
     * @return
     *     The open
     */
    public Boolean getOpen() {
        return open;
    }

    /**
     * 
     * @param open
     *     The open
     */
    public void setOpen(Boolean open) {
        this.open = open;
    }

    /**
     * 
     * @return
     *     The categories
     */
    public List<String> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The reviewCount
     */
    public Integer getReviewCount() {
        return reviewCount;
    }

    /**
     * 
     * @param reviewCount
     *     The review_count
     */
    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The neighborhoods
     */
    public List<Object> getNeighborhoods() {
        return neighborhoods;
    }

    /**
     * 
     * @param neighborhoods
     *     The neighborhoods
     */
    public void setNeighborhoods(List<Object> neighborhoods) {
        this.neighborhoods = neighborhoods;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 
     * @return
     *     The state
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The stars
     */
    public Double getStars() {
        return stars;
    }

    /**
     * 
     * @param stars
     *     The stars
     */
    public void setStars(Double stars) {
        this.stars = stars;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     *     The attributes
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

}
