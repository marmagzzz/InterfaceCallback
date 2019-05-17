package io.github.marmagzzz.makepupp.activity.leadspackage.controller;

import io.github.marmagzzz.makepupp.Listing.ListingInterface;
import io.github.marmagzzz.makepupp.activity.leadspackage.RecyclerAdapter.LeadsAdapter;
import io.github.marmagzzz.makepupp.activity.leadspackage.model.ListingModel;
import io.github.marmagzzz.makepupp.activity.leadspackage.view.LeadsRecyclerViewFragment;
import io.github.marmagzzz.makepupp.my_interface.FetchingInterface;
import model.LeadsModel;
import retrofit2.Response;

import java.util.Timer;
import java.util.TimerTask;

public class ListingController {

    private ListingModel listingModel;
    private LeadsRecyclerViewFragment leadsRecyclerViewFragment;

    private String userId;

    private Timer taskTimer;
    private LeadsAdapter leadsAdapter;

    public ListingController( ListingModel listingModel,
                              LeadsRecyclerViewFragment leadsRecyclerViewFragment,
                              String userId) {
        this.listingModel = listingModel;
        this.leadsRecyclerViewFragment = leadsRecyclerViewFragment;
        this.userId = userId;

        this.taskTimer = new Timer();
        this.leadsAdapter = new LeadsAdapter(null);
        this.listingModel = listingModel;

    }

    public void fetchListing(final FetchingInterface fetchingInterface){

        listingModel.fetchLeadRecordList(userId, new ListingInterface() {
            @Override
            public void onSuccess(Response<LeadsModel> leadsModelResponse, final int page) {

                //Current listing += from http request
                //Save to model class
                listingModel.setLeadRecordsList(leadsModelResponse.body().getLeads().getRecords());

                //Set new array list to adapter
                leadsAdapter = new LeadsAdapter(listingModel.getLeadRecordsList());

                //Set callback for request
                fetchingInterface.onSuccessFetchingList(leadsAdapter);

                //Repeat after 10 seconds
                taskTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        listingModel.setPage(page + 1); //increment page
                        fetchListing(fetchingInterface);
                    }
                }, 10000);

            }

            @Override
            public void onFail(String message, int page) {
                //Fails when something is wrong on http request or connection
                System.out.println("ON FAIL: " + message);
                fetchingInterface.onFailFetchingList(message);
            }

            @Override
            public void onMaxPage(String message, int page) {
                //Reached max page of list
                System.out.println("ON REACHED MAX PAGE: " + message);
                fetchingInterface.onFailFetchingList(message);
            }
        });

    }



}
