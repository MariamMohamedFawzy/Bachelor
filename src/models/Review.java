
package models;

import java.io.Serializable;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Review implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("votes")
    @Expose
    private Votes votes;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("review_id")
    @Expose
    private String reviewId;
    @SerializedName("stars")
    @Expose
    private Integer stars;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("business_id")
    @Expose
    private String businessId;
    
    private int id;
    
    public int getId() {
    	return this.id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }

    /**
     * 
     * @return
     *     The votes
     */
    public Votes getVotes() {
        return votes;
    }

    /**
     * 
     * @param votes
     *     The votes
     */
    public void setVotes(Votes votes) {
        this.votes = votes;
    }

    /**
     * 
     * @return
     *     The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId
     *     The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return
     *     The reviewId
     */
    public String getReviewId() {
        return reviewId;
    }

    /**
     * 
     * @param reviewId
     *     The review_id
     */
    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    /**
     * 
     * @return
     *     The stars
     */
    public Integer getStars() {
        return stars;
    }

    /**
     * 
     * @param stars
     *     The stars
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
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

}
