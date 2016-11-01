
package models;

import java.io.Serializable;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Votes implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("funny")
    @Expose
    private Integer funny;
    @SerializedName("useful")
    @Expose
    private Integer useful;
    @SerializedName("cool")
    @Expose
    private Integer cool;

    /**
     * 
     * @return
     *     The funny
     */
    public Integer getFunny() {
        return funny;
    }

    /**
     * 
     * @param funny
     *     The funny
     */
    public void setFunny(Integer funny) {
        this.funny = funny;
    }

    /**
     * 
     * @return
     *     The useful
     */
    public Integer getUseful() {
        return useful;
    }

    /**
     * 
     * @param useful
     *     The useful
     */
    public void setUseful(Integer useful) {
        this.useful = useful;
    }

    /**
     * 
     * @return
     *     The cool
     */
    public Integer getCool() {
        return cool;
    }

    /**
     * 
     * @param cool
     *     The cool
     */
    public void setCool(Integer cool) {
        this.cool = cool;
    }

}
