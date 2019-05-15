package io.github.marmagzzz.makepupp.Listing;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import io.github.marmagzzz.makepupp.adapter.LeadsAdapter;
import model.LeadsModel;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ListingController {

    private ListingModel listingModel;
    private String userId;
    private Timer taskTimer;
    private RecyclerView recyclerView;
    private LeadsAdapter leadsAdapter;
    private ArrayList<model.Record> listingArrayList;

    public ListingController(String userId, int page, RecyclerView recyclerView) {
        this.userId = userId;
        this.recyclerView = recyclerView;

        this.taskTimer = new Timer();
        this.leadsAdapter = new LeadsAdapter(null);
        this.listingModel = new ListingModel();
        this.listingArrayList = new ArrayList<>();
    }

    public void fetchListing(){
        listingModel.getLeadRecordsList(userId, new ListingInterface() {
            @Override
            public void onSuccess(Response<LeadsModel> leadsModelResponse, final int page) {
                listingArrayList.addAll(leadsModelResponse.body().getLeads().getRecords());
                leadsAdapter = new LeadsAdapter(listingArrayList);
                recyclerView.setAdapter(leadsAdapter);
                taskTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        listingModel.setPage(page + 1); //increment page
                        fetchListing();
                    }
                }, 2000);
            }

            @Override
            public void onFail(String message, int page) {
                System.out.println("ON FAIL: " + message);
            }

            @Override
            public void onMaxPage(String message, int page) {
                System.out.println("ON REACHED MAX PAGE: " + message);
            }
        });
    }



}
