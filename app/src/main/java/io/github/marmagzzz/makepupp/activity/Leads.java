package io.github.marmagzzz.makepupp.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import io.github.marmagzzz.makepupp.Listing.ListingController;
import io.github.marmagzzz.makepupp.Listing.ListingModel;
import io.github.marmagzzz.makepupp.R;
import io.github.marmagzzz.makepupp.adapter.LeadsAdapter;
import io.github.marmagzzz.makepupp.my_interface.FetchingInterface;

public class Leads extends AppCompatActivity {

    private String userId;
    private Intent intent;

    private RecyclerView recyclerView;

    private ListingController listingController;
    private Parcelable recyclerViewState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lead);

        intent = getIntent();
        userId = intent.getStringExtra("userId");
        listingController = new ListingController(userId);

        recyclerView = findViewById(R.id.lead_recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Leads.this);
        recyclerView.setLayoutManager(layoutManager);

        listingController.fetchListing(new FetchingInterface() {
            @Override
            public void onSuccessFetchingList(LeadsAdapter leadsAdapter) {
                recyclerViewState = recyclerView.getLayoutManager().onSaveInstanceState(); //save last position
                recyclerView.setAdapter(leadsAdapter);
                recyclerView.getLayoutManager().onRestoreInstanceState(recyclerViewState); //restore last position
            }

            @Override
            public void onFailFetchingList(String message) {
                Toast.makeText(Leads.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
