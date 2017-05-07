package pt.meo.test.nowandnextsampleapp.network.response.models;

/**
 * Created by dplopez on 07-05-2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Holder of the Channel information
 */
public class ChannelInformation {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("IsAdult")
    @Expose
    private Boolean isAdult;
    @SerializedName("InPromotion")
    @Expose
    private Boolean inPromotion;
    @SerializedName("PromotionDescription")
    @Expose
    private Object promotionDescription;
    @SerializedName("ProductKey")
    @Expose
    private String productKey;
    @SerializedName("ParentalRating")
    @Expose
    private Object parentalRating;
    @SerializedName("CatalogPrice")
    @Expose
    private String catalogPrice;
    @SerializedName("AvailableOnChannels")
    @Expose
    private String availableOnChannels;
    @SerializedName("Thematic")
    @Expose
    private String thematic;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("CatalogOrderNumber")
    @Expose
    private Integer catalogOrderNumber;
    @SerializedName("DeviceSubscription")
    @Expose
    private Boolean deviceSubscription;
    @SerializedName("PresentationKey")
    @Expose
    private String presentationKey;
    @SerializedName("IsSpecialPromotion")
    @Expose
    private Boolean isSpecialPromotion;
    @SerializedName("CommercialKey")
    @Expose
    private String commercialKey;
    @SerializedName("ImageQuality")
    @Expose
    private String imageQuality;
    @SerializedName("ExclusiveContent")
    @Expose
    private Boolean exclusiveContent;
    @SerializedName("RestartTV")
    @Expose
    private Boolean restartTV;
    @SerializedName("HasL2Vs")
    @Expose
    private Boolean hasL2Vs;
    @SerializedName("Interactive")
    @Expose
    private Boolean interactive;
    @SerializedName("Region")
    @Expose
    private String region;
    @SerializedName("CallLetter")
    @Expose
    private String callLetter;
    @SerializedName("ChannelPosition")
    @Expose
    private Integer channelPosition;
    @SerializedName("Language")
    @Expose
    private String language;
    @SerializedName("Subtitled")
    @Expose
    private Boolean subtitled;
    @SerializedName("MinimumSubscriptionDays")
    @Expose
    private Integer minimumSubscriptionDays;
    @SerializedName("IsLiveAnyTime")
    @Expose
    private Boolean isLiveAnyTime;
    @SerializedName("FriendlyUrlName")
    @Expose
    private String friendlyUrlName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsAdult() {
        return isAdult;
    }

    public void setIsAdult(Boolean isAdult) {
        this.isAdult = isAdult;
    }

    public Boolean getInPromotion() {
        return inPromotion;
    }

    public void setInPromotion(Boolean inPromotion) {
        this.inPromotion = inPromotion;
    }

    public Object getPromotionDescription() {
        return promotionDescription;
    }

    public void setPromotionDescription(Object promotionDescription) {
        this.promotionDescription = promotionDescription;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public Object getParentalRating() {
        return parentalRating;
    }

    public void setParentalRating(Object parentalRating) {
        this.parentalRating = parentalRating;
    }

    public String getCatalogPrice() {
        return catalogPrice;
    }

    public void setCatalogPrice(String catalogPrice) {
        this.catalogPrice = catalogPrice;
    }

    public String getAvailableOnChannels() {
        return availableOnChannels;
    }

    public void setAvailableOnChannels(String availableOnChannels) {
        this.availableOnChannels = availableOnChannels;
    }

    public String getThematic() {
        return thematic;
    }

    public void setThematic(String thematic) {
        this.thematic = thematic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCatalogOrderNumber() {
        return catalogOrderNumber;
    }

    public void setCatalogOrderNumber(Integer catalogOrderNumber) {
        this.catalogOrderNumber = catalogOrderNumber;
    }

    public Boolean getDeviceSubscription() {
        return deviceSubscription;
    }

    public void setDeviceSubscription(Boolean deviceSubscription) {
        this.deviceSubscription = deviceSubscription;
    }

    public String getPresentationKey() {
        return presentationKey;
    }

    public void setPresentationKey(String presentationKey) {
        this.presentationKey = presentationKey;
    }

    public Boolean getIsSpecialPromotion() {
        return isSpecialPromotion;
    }

    public void setIsSpecialPromotion(Boolean isSpecialPromotion) {
        this.isSpecialPromotion = isSpecialPromotion;
    }

    public String getCommercialKey() {
        return commercialKey;
    }

    public void setCommercialKey(String commercialKey) {
        this.commercialKey = commercialKey;
    }

    public String getImageQuality() {
        return imageQuality;
    }

    public void setImageQuality(String imageQuality) {
        this.imageQuality = imageQuality;
    }

    public Boolean getExclusiveContent() {
        return exclusiveContent;
    }

    public void setExclusiveContent(Boolean exclusiveContent) {
        this.exclusiveContent = exclusiveContent;
    }

    public Boolean getRestartTV() {
        return restartTV;
    }

    public void setRestartTV(Boolean restartTV) {
        this.restartTV = restartTV;
    }

    public Boolean getHasL2Vs() {
        return hasL2Vs;
    }

    public void setHasL2Vs(Boolean hasL2Vs) {
        this.hasL2Vs = hasL2Vs;
    }

    public Boolean getInteractive() {
        return interactive;
    }

    public void setInteractive(Boolean interactive) {
        this.interactive = interactive;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCallLetter() {
        return callLetter;
    }

    public void setCallLetter(String callLetter) {
        this.callLetter = callLetter;
    }

    public Integer getChannelPosition() {
        return channelPosition;
    }

    public void setChannelPosition(Integer channelPosition) {
        this.channelPosition = channelPosition;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getSubtitled() {
        return subtitled;
    }

    public void setSubtitled(Boolean subtitled) {
        this.subtitled = subtitled;
    }

    public Integer getMinimumSubscriptionDays() {
        return minimumSubscriptionDays;
    }

    public void setMinimumSubscriptionDays(Integer minimumSubscriptionDays) {
        this.minimumSubscriptionDays = minimumSubscriptionDays;
    }

    public Boolean getIsLiveAnyTime() {
        return isLiveAnyTime;
    }

    public void setIsLiveAnyTime(Boolean isLiveAnyTime) {
        this.isLiveAnyTime = isLiveAnyTime;
    }

    public String getFriendlyUrlName() {
        return friendlyUrlName;
    }

    public void setFriendlyUrlName(String friendlyUrlName) {
        this.friendlyUrlName = friendlyUrlName;
    }

}