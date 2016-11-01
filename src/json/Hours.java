
package json;

import java.io.Serializable;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Hours implements Serializable {

    @SerializedName("Friday")
    @Expose
    private Friday friday;
    @SerializedName("Tuesday")
    @Expose
    private Tuesday tuesday;
    @SerializedName("Thursday")
    @Expose
    private Thursday thursday;
    @SerializedName("Wednesday")
    @Expose
    private Wednesday wednesday;
    @SerializedName("Monday")
    @Expose
    private Monday monday;

    /**
     * 
     * @return
     *     The friday
     */
    public Friday getFriday() {
        return friday;
    }

    /**
     * 
     * @param friday
     *     The Friday
     */
    public void setFriday(Friday friday) {
        this.friday = friday;
    }

    /**
     * 
     * @return
     *     The tuesday
     */
    public Tuesday getTuesday() {
        return tuesday;
    }

    /**
     * 
     * @param tuesday
     *     The Tuesday
     */
    public void setTuesday(Tuesday tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * 
     * @return
     *     The thursday
     */
    public Thursday getThursday() {
        return thursday;
    }

    /**
     * 
     * @param thursday
     *     The Thursday
     */
    public void setThursday(Thursday thursday) {
        this.thursday = thursday;
    }

    /**
     * 
     * @return
     *     The wednesday
     */
    public Wednesday getWednesday() {
        return wednesday;
    }

    /**
     * 
     * @param wednesday
     *     The Wednesday
     */
    public void setWednesday(Wednesday wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * 
     * @return
     *     The monday
     */
    public Monday getMonday() {
        return monday;
    }

    /**
     * 
     * @param monday
     *     The Monday
     */
    public void setMonday(Monday monday) {
        this.monday = monday;
    }

}
