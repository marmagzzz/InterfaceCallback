
package model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("email_address")
    @Expose
    private String emailAddress;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("social_img")
    @Expose
    private Object socialImg;
    @SerializedName("profile_img")
    @Expose
    private Object profileImg;
    @SerializedName("pay_plan_id")
    @Expose
    private Integer payPlanId;
    @SerializedName("pay_plan")
    @Expose
    private List<PayPlan> payPlan = null;
    @SerializedName("email_signature")
    @Expose
    private Object emailSignature;
    @SerializedName("plan_expiry_date")
    @Expose
    private String planExpiryDate;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Object getSocialImg() {
        return socialImg;
    }

    public void setSocialImg(Object socialImg) {
        this.socialImg = socialImg;
    }

    public Object getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(Object profileImg) {
        this.profileImg = profileImg;
    }

    public Integer getPayPlanId() {
        return payPlanId;
    }

    public void setPayPlanId(Integer payPlanId) {
        this.payPlanId = payPlanId;
    }

    public List<PayPlan> getPayPlan() {
        return payPlan;
    }

    public void setPayPlan(List<PayPlan> payPlan) {
        this.payPlan = payPlan;
    }

    public Object getEmailSignature() {
        return emailSignature;
    }

    public void setEmailSignature(Object emailSignature) {
        this.emailSignature = emailSignature;
    }

    public String getPlanExpiryDate() {
        return planExpiryDate;
    }

    public void setPlanExpiryDate(String planExpiryDate) {
        this.planExpiryDate = planExpiryDate;
    }

}
