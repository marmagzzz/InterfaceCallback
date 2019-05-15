
package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayPlan {

    @SerializedName("pay_plan_id")
    @Expose
    private Integer payPlanId;
    @SerializedName("plan_description")
    @Expose
    private String planDescription;

    public Integer getPayPlanId() {
        return payPlanId;
    }

    public void setPayPlanId(Integer payPlanId) {
        this.payPlanId = payPlanId;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

}
