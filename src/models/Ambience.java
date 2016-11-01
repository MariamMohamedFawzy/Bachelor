
package models;

import java.io.Serializable;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Ambience implements Serializable {

    @SerializedName("romantic")
    @Expose
    private Boolean romantic;
    @SerializedName("intimate")
    @Expose
    private Boolean intimate;
    @SerializedName("classy")
    @Expose
    private Boolean classy;
    @SerializedName("hipster")
    @Expose
    private Boolean hipster;
    @SerializedName("divey")
    @Expose
    private Boolean divey;
    @SerializedName("touristy")
    @Expose
    private Boolean touristy;
    @SerializedName("trendy")
    @Expose
    private Boolean trendy;
    @SerializedName("upscale")
    @Expose
    private Boolean upscale;
    @SerializedName("casual")
    @Expose
    private Boolean casual;

    /**
     * 
     * @return
     *     The romantic
     */
    public Boolean getRomantic() {
        return romantic;
    }

    /**
     * 
     * @param romantic
     *     The romantic
     */
    public void setRomantic(Boolean romantic) {
        this.romantic = romantic;
    }

    /**
     * 
     * @return
     *     The intimate
     */
    public Boolean getIntimate() {
        return intimate;
    }

    /**
     * 
     * @param intimate
     *     The intimate
     */
    public void setIntimate(Boolean intimate) {
        this.intimate = intimate;
    }

    /**
     * 
     * @return
     *     The classy
     */
    public Boolean getClassy() {
        return classy;
    }

    /**
     * 
     * @param classy
     *     The classy
     */
    public void setClassy(Boolean classy) {
        this.classy = classy;
    }

    /**
     * 
     * @return
     *     The hipster
     */
    public Boolean getHipster() {
        return hipster;
    }

    /**
     * 
     * @param hipster
     *     The hipster
     */
    public void setHipster(Boolean hipster) {
        this.hipster = hipster;
    }

    /**
     * 
     * @return
     *     The divey
     */
    public Boolean getDivey() {
        return divey;
    }

    /**
     * 
     * @param divey
     *     The divey
     */
    public void setDivey(Boolean divey) {
        this.divey = divey;
    }

    /**
     * 
     * @return
     *     The touristy
     */
    public Boolean getTouristy() {
        return touristy;
    }

    /**
     * 
     * @param touristy
     *     The touristy
     */
    public void setTouristy(Boolean touristy) {
        this.touristy = touristy;
    }

    /**
     * 
     * @return
     *     The trendy
     */
    public Boolean getTrendy() {
        return trendy;
    }

    /**
     * 
     * @param trendy
     *     The trendy
     */
    public void setTrendy(Boolean trendy) {
        this.trendy = trendy;
    }

    /**
     * 
     * @return
     *     The upscale
     */
    public Boolean getUpscale() {
        return upscale;
    }

    /**
     * 
     * @param upscale
     *     The upscale
     */
    public void setUpscale(Boolean upscale) {
        this.upscale = upscale;
    }

    /**
     * 
     * @return
     *     The casual
     */
    public Boolean getCasual() {
        return casual;
    }

    /**
     * 
     * @param casual
     *     The casual
     */
    public void setCasual(Boolean casual) {
        this.casual = casual;
    }

}
