
package models;

import java.io.Serializable;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class GoodFor implements Serializable {

    @SerializedName("dessert")
    @Expose
    private Boolean dessert;
    @SerializedName("latenight")
    @Expose
    private Boolean latenight;
    @SerializedName("lunch")
    @Expose
    private Boolean lunch;
    @SerializedName("dinner")
    @Expose
    private Boolean dinner;
    @SerializedName("brunch")
    @Expose
    private Boolean brunch;
    @SerializedName("breakfast")
    @Expose
    private Boolean breakfast;

    /**
     * 
     * @return
     *     The dessert
     */
    public Boolean getDessert() {
        return dessert;
    }

    /**
     * 
     * @param dessert
     *     The dessert
     */
    public void setDessert(Boolean dessert) {
        this.dessert = dessert;
    }

    /**
     * 
     * @return
     *     The latenight
     */
    public Boolean getLatenight() {
        return latenight;
    }

    /**
     * 
     * @param latenight
     *     The latenight
     */
    public void setLatenight(Boolean latenight) {
        this.latenight = latenight;
    }

    /**
     * 
     * @return
     *     The lunch
     */
    public Boolean getLunch() {
        return lunch;
    }

    /**
     * 
     * @param lunch
     *     The lunch
     */
    public void setLunch(Boolean lunch) {
        this.lunch = lunch;
    }

    /**
     * 
     * @return
     *     The dinner
     */
    public Boolean getDinner() {
        return dinner;
    }

    /**
     * 
     * @param dinner
     *     The dinner
     */
    public void setDinner(Boolean dinner) {
        this.dinner = dinner;
    }

    /**
     * 
     * @return
     *     The brunch
     */
    public Boolean getBrunch() {
        return brunch;
    }

    /**
     * 
     * @param brunch
     *     The brunch
     */
    public void setBrunch(Boolean brunch) {
        this.brunch = brunch;
    }

    /**
     * 
     * @return
     *     The breakfast
     */
    public Boolean getBreakfast() {
        return breakfast;
    }

    /**
     * 
     * @param breakfast
     *     The breakfast
     */
    public void setBreakfast(Boolean breakfast) {
        this.breakfast = breakfast;
    }

}
