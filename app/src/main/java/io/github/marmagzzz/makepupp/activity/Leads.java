package io.github.marmagzzz.makepupp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import io.github.marmagzzz.makepupp.Listing.ListingController;
import io.github.marmagzzz.makepupp.Listing.ListingModel;
import io.github.marmagzzz.makepupp.R;
import io.github.marmagzzz.makepupp.adapter.LeadsAdapter;
import io.github.marmagzzz.makepupp.my_interface.FetchingInterface;

public class Leads extends AppCompatActivity {

    private String userId;
    private Intent intent;
    private int page = 0;

    private RecyclerView recyclerView;

    private ListingController listingController;

    private ListingModel listingModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lead);

        intent = getIntent();
        userId = intent.getStringExtra("userId");

        recyclerView = findViewById(R.id.lead_recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Leads.this);
        recyclerView.setLayoutManager(layoutManager);

        listingController = new ListingController(userId);

        listingController.fetchListing(recyclerView);

    }


}
