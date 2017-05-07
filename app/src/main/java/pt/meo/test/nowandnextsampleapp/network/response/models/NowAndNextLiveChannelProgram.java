package pt.meo.test.nowandnextsampleapp.network.response.models;

/**
 * Channel list Pojo
 * Created by dplopez on 07-05-2017.
 */

        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class NowAndNextLiveChannelProgram {

    @SerializedName("odata.metadata")
    @Expose
    private String odataMetadata;
    @SerializedName("value")
    @Expose
    private List<ChannelProgramInformation> channelProgramList = null;

    public String getOdataMetadata() {
        return odataMetadata;
    }

    public void setOdataMetadata(String odataMetadata) {
        this.odataMetadata = odataMetadata;
    }

    public List<ChannelProgramInformation> getChannelProgramList() {
        return channelProgramList;
    }

    public void setChannelProgramList(List<ChannelProgramInformation> channelProgramList) {
        this.channelProgramList = channelProgramList;
    }

}