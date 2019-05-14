
package model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Leads {

    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;
    @SerializedName("records")
    @Expose
    private ArrayList<model.Record> records = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public ArrayList<model.Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<model.Record> records) {
        this.records = records;
    }

}
