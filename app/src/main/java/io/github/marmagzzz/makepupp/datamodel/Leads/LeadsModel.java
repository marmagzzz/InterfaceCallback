
package model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeadsModel {

    @SerializedName("leads")
    @Expose
    private model.Leads leads;
    @SerializedName("contacts")
    @Expose
    private ArrayList<model.Contact> contacts = null;

    public model.Leads getLeads() {
        return leads;
    }

    public void setLeads(model.Leads leads) {
        this.leads = leads;
    }

    public ArrayList<model.Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<model.Contact> contacts) {
        this.contacts = contacts;
    }

}
