package pt.meo.test.nowandnextsampleapp.network.response.models;

/**
 * Channel Program Information POJO
 * Created by dplopez on 07-05-2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChannelProgramInformation {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("CallLetter")
    @Expose
    private String callLetter;
    @SerializedName("StartDate")
    @Expose
    private String startDate;
    @SerializedName("StartTime")
    @Expose
    private String startTime;
    @SerializedName("ProgramId")
    @Expose
    private Integer programId;
    @SerializedName("EndDate")
    @Expose
    private String endDate;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Synopsis")
    @Expose
    private String synopsis;
    @SerializedName("SeriesId")
    @Expose
    private Integer seriesId;
    @SerializedName("SeriesEpisodeNumber")
    @Expose
    private Integer seriesEpisodeNumber;
    @SerializedName("Participants")
    @Expose
    private String participants;
    @SerializedName("ImageUri")
    @Expose
    private Object imageUri;
    @SerializedName("IsAdultContent")
    @Expose
    private Boolean isAdultContent;
    @SerializedName("IsEnabled")
    @Expose
    private Boolean isEnabled;
    @SerializedName("SearchRank")
    @Expose
    private Integer searchRank;
    @SerializedName("NumberOfEpisodes")
    @Expose
    private Integer numberOfEpisodes;
    @SerializedName("IsLiveAnytimeChannel")
    @Expose
    private Boolean isLiveAnytimeChannel;
    @SerializedName("TitleId")
    @Expose
    private String titleId;
    @SerializedName("IsBlackout")
    @Expose
    private Boolean isBlackout;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCallLetter() {
        return callLetter;
    }

    public void setCallLetter(String callLetter) {
        this.callLetter = callLetter;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public Integer getSeriesEpisodeNumber() {
        return seriesEpisodeNumber;
    }

    public void setSeriesEpisodeNumber(Integer seriesEpisodeNumber) {
        this.seriesEpisodeNumber = seriesEpisodeNumber;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public Object getImageUri() {
        return imageUri;
    }

    public void setImageUri(Object imageUri) {
        this.imageUri = imageUri;
    }

    public Boolean getIsAdultContent() {
        return isAdultContent;
    }

    public void setIsAdultContent(Boolean isAdultContent) {
        this.isAdultContent = isAdultContent;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getSearchRank() {
        return searchRank;
    }

    public void setSearchRank(Integer searchRank) {
        this.searchRank = searchRank;
    }

    public Integer getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(Integer numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public Boolean getIsLiveAnytimeChannel() {
        return isLiveAnytimeChannel;
    }

    public void setIsLiveAnytimeChannel(Boolean isLiveAnytimeChannel) {
        this.isLiveAnytimeChannel = isLiveAnytimeChannel;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public Boolean getIsBlackout() {
        return isBlackout;
    }

    public void setIsBlackout(Boolean isBlackout) {
        this.isBlackout = isBlackout;
    }

}