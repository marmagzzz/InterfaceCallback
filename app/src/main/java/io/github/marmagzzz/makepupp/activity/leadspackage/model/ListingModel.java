package io.github.marmagzzz.makepupp.activity.leadspackage.model;

import io.github.marmagzzz.makepupp.Listing.ListingInterface;
import io.github.marmagzzz.makepupp.my_interface.LeadsApi;
import model.LeadsModel;
import model.Record;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
public class ListingModel {

    private ArrayList<model.Record> leadRecordsList;
    private LeadsApi leadsApi;
    private Retrofit retrofit;
    private int page;
    private String userId;

    public ListingModel(String userId) {
        this.userId = userId;
        this.page = 0;
        this.leadRecordsList = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<Record> getLeadRecordsList() {
        return leadRecordsList;
    }

    public void setLeadRecordsList(ArrayList<Record> leadRecordsList) {
        this.leadRecordsList.addAll(leadRecordsList);
    }


    public void fetchLeadRecordList (String userId, final ListingInterface listingInterface) {
        retrofit = new Retrofit.Builder()
            .baseUrl("https://app.prosperna.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        leadsApi = retrofit.create(LeadsApi.class);

        Call<model.LeadsModel> call = leadsApi.getLeads(userId, page);

        call.enqueue(new Callback<LeadsModel>() {
            @Override
            public void onResponse(Call<LeadsModel> call, Response<LeadsModel> response) {
                if(response.isSuccessful()){
                    if(page < response.body().getLeads().getTotalPages()){
                        listingInterface.onSuccess(response, page);
                    }
                    else{//max page
                        listingInterface.onMaxPage("You reached max page.", page);
                    }
                }
                else{
                    listingInterface.onFail("Failed to load. Page: " + page, page);
                }
            }

            @Override
            public void onFailure(Call<LeadsModel> call, Throwable t) {
                listingInterface.onFail("Failed to load. Page: " + page, page);
            }
        });




    }

}
