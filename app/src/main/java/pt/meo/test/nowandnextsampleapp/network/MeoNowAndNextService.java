package pt.meo.test.nowandnextsampleapp.network;

import pt.meo.test.nowandnextsampleapp.network.response.models.ChannelList;
import pt.meo.test.nowandnextsampleapp.network.response.models.NowAndNextLiveChannelProgram;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Retrofit service interface for to get the channel list and programming info
 * Created by dplopez on 07-05-2017.
 */
public interface MeoNowAndNextService {
    String BASE_URL = "http://ott.online.meo.pt";
    String CALL_LETTER_EQ = "CallLetter  eq '%s'";
    @GET("/catalog/v6/Channels?UserAgent=AND&$filter=substringof('MEO_Mobile',AvailableOnChannels) and IsAdult eq false&$orderby=ChannelPosition asc&$inlinecount=allpages")
    Call<ChannelList> getChannelList(); // gets the first channel list
    @GET
    Call<ChannelList> getChannelListCall(@Url String url); // gets the "next" url
    @GET("/Program/v6/Programs/NowAndNextLiveChannelPrograms?UserAgent=AND")
    Call<NowAndNextLiveChannelProgram> getChannelNowAndNext(@Query("$filter") String callLetter);
}
