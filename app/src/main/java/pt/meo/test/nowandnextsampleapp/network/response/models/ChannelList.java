package pt.meo.test.nowandnextsampleapp.network.response.models;

/**
 * Channel list POJO
 * Created by dplopez on 07-05-2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Holder of the channel list
 */
public class ChannelList {

    @SerializedName("odata.metadata")
    @Expose
    private String odataMetadata;
    @SerializedName("odata.count")
    @Expose
    private Integer odataCount;
    @SerializedName("value")
    @Expose
    private List<ChannelInformation> channelInformation = null;
    @SerializedName("odata.nextLink")
    @Expose
    private String nextChannelPage;

    /**
     * Getter for the Metadata
     * @return
     */
    public String getOdataMetadata() {
        return odataMetadata;
    }

    public void setOdataMetadata(String odataMetadata) {
        this.odataMetadata = odataMetadata;
    }

    public Integer getOdataCount() {
        return odataCount;
    }

    public void setOdataCount(Integer odataCount) {
        this.odataCount = odataCount;
    }

    public List<ChannelInformation> getChannelInformation() {
        return channelInformation;
    }

    public void setChannelInformation(List<ChannelInformation> channelInformation) {
        this.channelInformation = channelInformation;
    }

    public String getNextChannelPage() {
        return nextChannelPage;
    }

    public void setNextChannelPage(String nextChannelPage) {
        this.nextChannelPage = nextChannelPage;
    }

}