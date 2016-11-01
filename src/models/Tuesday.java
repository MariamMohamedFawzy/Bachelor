
package models;

import java.io.Serializable;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Tuesday implements Serializable {

    @SerializedName("close")
    @Expose
    private String close;
    @SerializedName("open")
    @Expose
    private String open;

    /**
     * 
     * @return
     *     The close
     */
    public String getClose() {
        return close;
    }

    /**
     * 
     * @param close
     *     The close
     */
    public void setClose(String close) {
        this.close = close;
    }

    /**
     * 
     * @return
     *     The open
     */
    public String getOpen() {
        return open;
    }

    /**
     * 
     * @param open
     *     The open
     */
    public void setOpen(String open) {
        this.open = open;
    }

}
