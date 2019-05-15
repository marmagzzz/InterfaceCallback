
package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Record {

    @SerializedName("lead_id")
    @Expose
    private Integer leadId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("segment_id")
    @Expose
    private Integer segmentId;
    @SerializedName("email_address")
    @Expose
    private String emailAddress;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("city")
    @Expose
    private Object city;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("postal_code")
    @Expose
    private Object postalCode;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("profile_img")
    @Expose
    private Object profileImg;
    @SerializedName("facebook_link")
    @Expose
    private Object facebookLink;
    @SerializedName("twitter_link")
    @Expose
    private Object twitterLink;
    @SerializedName("linked_in_link")
    @Expose
    private Object linkedInLink;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("google_plus_link")
    @Expose
    private Object googlePlusLink;
    @SerializedName("instagram_link")
    @Expose
    private Object instagramLink;
    @SerializedName("contact_number")
    @Expose
    private String contactNumber;
    @SerializedName("youtube_link")
    @Expose
    private Object youtubeLink;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("pinterest_link")
    @Expose
    private Object pinterestLink;
    @SerializedName("is_trashed")
    @Expose
    private Integer isTrashed;
    @SerializedName("physical_address")
    @Expose
    private Object physicalAddress;
    @SerializedName("job_title")
    @Expose
    private String jobTitle;
    @SerializedName("lead_priority")
    @Expose
    private Integer leadPriority;
    @SerializedName("lead_source_id")
    @Expose
    private Integer leadSourceId;
    @SerializedName("lead_status_id")
    @Expose
    private Integer leadStatusId;
    @SerializedName("web_form_comment")
    @Expose
    private Object webFormComment;
    @SerializedName("favorite_ratings")
    @Expose
    private Integer favoriteRatings;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("salutations")
    @Expose
    private Object salutations;
    @SerializedName("website_url")
    @Expose
    private Object websiteUrl;
    @SerializedName("from_landing_page")
    @Expose
    private Object fromLandingPage;
    @SerializedName("from_landing_page_id")
    @Expose
    private Object fromLandingPageId;
    @SerializedName("email_opt_in")
    @Expose
    private Integer emailOptIn;
    @SerializedName("broker_name")
    @Expose
    private Object brokerName;
    @SerializedName("segment_order")
    @Expose
    private Integer segmentOrder;
    @SerializedName("owner_fname")
    @Expose
    private String ownerFname;
    @SerializedName("owner_lname")
    @Expose
    private String ownerLname;
    @SerializedName("lead_source_description")
    @Expose
    private String leadSourceDescription;
    @SerializedName("segments_id")
    @Expose
    private Integer segmentsId;
    @SerializedName("segment_name")
    @Expose
    private String segmentName;
    @SerializedName("lead_status_description")
    @Expose
    private String leadStatusDescription;

    public Integer getLeadId() {
        return leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(Integer segmentId) {
        this.segmentId = segmentId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(Object profileImg) {
        this.profileImg = profileImg;
    }

    public Object getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(Object facebookLink) {
        this.facebookLink = facebookLink;
    }

    public Object getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(Object twitterLink) {
        this.twitterLink = twitterLink;
    }

    public Object getLinkedInLink() {
        return linkedInLink;
    }

    public void setLinkedInLink(Object linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Object getGooglePlusLink() {
        return googlePlusLink;
    }

    public void setGooglePlusLink(Object googlePlusLink) {
        this.googlePlusLink = googlePlusLink;
    }

    public Object getInstagramLink() {
        return instagramLink;
    }

    public void setInstagramLink(Object instagramLink) {
        this.instagramLink = instagramLink;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Object getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(Object youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getPinterestLink() {
        return pinterestLink;
    }

    public void setPinterestLink(Object pinterestLink) {
        this.pinterestLink = pinterestLink;
    }

    public Integer getIsTrashed() {
        return isTrashed;
    }

    public void setIsTrashed(Integer isTrashed) {
        this.isTrashed = isTrashed;
    }

    public Object getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(Object physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getLeadPriority() {
        return leadPriority;
    }

    public void setLeadPriority(Integer leadPriority) {
        this.leadPriority = leadPriority;
    }

    public Integer getLeadSourceId() {
        return leadSourceId;
    }

    public void setLeadSourceId(Integer leadSourceId) {
        this.leadSourceId = leadSourceId;
    }

    public Integer getLeadStatusId() {
        return leadStatusId;
    }

    public void setLeadStatusId(Integer leadStatusId) {
        this.leadStatusId = leadStatusId;
    }

    public Object getWebFormComment() {
        return webFormComment;
    }

    public void setWebFormComment(Object webFormComment) {
        this.webFormComment = webFormComment;
    }

    public Integer getFavoriteRatings() {
        return favoriteRatings;
    }

    public void setFavoriteRatings(Integer favoriteRatings) {
        this.favoriteRatings = favoriteRatings;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Object getSalutations() {
        return salutations;
    }

    public void setSalutations(Object salutations) {
        this.salutations = salutations;
    }

    public Object getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(Object websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public Object getFromLandingPage() {
        return fromLandingPage;
    }

    public void setFromLandingPage(Object fromLandingPage) {
        this.fromLandingPage = fromLandingPage;
    }

    public Object getFromLandingPageId() {
        return fromLandingPageId;
    }

    public void setFromLandingPageId(Object fromLandingPageId) {
        this.fromLandingPageId = fromLandingPageId;
    }

    public Integer getEmailOptIn() {
        return emailOptIn;
    }

    public void setEmailOptIn(Integer emailOptIn) {
        this.emailOptIn = emailOptIn;
    }

    public Object getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(Object brokerName) {
        this.brokerName = brokerName;
    }

    public Integer getSegmentOrder() {
        return segmentOrder;
    }

    public void setSegmentOrder(Integer segmentOrder) {
        this.segmentOrder = segmentOrder;
    }

    public String getOwnerFname() {
        return ownerFname;
    }

    public void setOwnerFname(String ownerFname) {
        this.ownerFname = ownerFname;
    }

    public String getOwnerLname() {
        return ownerLname;
    }

    public void setOwnerLname(String ownerLname) {
        this.ownerLname = ownerLname;
    }

    public String getLeadSourceDescription() {
        return leadSourceDescription;
    }

    public void setLeadSourceDescription(String leadSourceDescription) {
        this.leadSourceDescription = leadSourceDescription;
    }

    public Integer getSegmentsId() {
        return segmentsId;
    }

    public void setSegmentsId(Integer segmentsId) {
        this.segmentsId = segmentsId;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public String getLeadStatusDescription() {
        return leadStatusDescription;
    }

    public void setLeadStatusDescription(String leadStatusDescription) {
        this.leadStatusDescription = leadStatusDescription;
    }

}
