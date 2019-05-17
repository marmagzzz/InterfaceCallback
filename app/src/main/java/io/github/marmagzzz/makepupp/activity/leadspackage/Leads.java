package io.github.marmagzzz.makepupp.activity.leadspackage;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import io.github.marmagzzz.makepupp.activity.leadspackage.controller.ListingController;
import io.github.marmagzzz.makepupp.activity.leadspackage.model.ListingModel;
import io.github.marmagzzz.makepupp.R;
import io.github.marmagzzz.makepupp.activity.leadspackage.RecyclerAdapter.LeadsAdapter;
import io.github.marmagzzz.makepupp.activity.leadspackage.view.LeadsRecyclerViewFragment;
import io.github.marmagzzz.makepupp.my_interface.FetchingInterface;

public class Leads extends AppCompatActivity {

    private String userId;
    private Intent intent;

    private ListingModel listingModel;

    private LeadsRecyclerViewFragment leadsRecyclerViewFragment;

    private ListingController listingController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lead);

        intent = getIntent();
        userId = intent.getStringExtra("userId");

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //MODEL
        listingModel = new ListingModel(userId);

        //VIEW
        leadsRecyclerViewFragment = new LeadsRecyclerViewFragment();

            //attaching fragment
            fragmentTransaction.add(R.id.leads_fragment_container, leadsRecyclerViewFragment);
            fragmentTransaction.commit();

        //CONTROLLER
        listingController = new ListingController(listingModel, leadsRecyclerViewFragment);

        listingController.fetchListing(new FetchingInterface() {
            @Override
            public void onSuccessFetchingList(LeadsAdapter leadsAdapter) {
                //Save state position of recycler view
                leadsRecyclerViewFragment.saveRecyclerViewCurrentPosition();

                //Set adapter for recycler view
                leadsRecyclerViewFragment.setListingAdapter(leadsAdapter);

                //Retaining position of view for recycler view
                leadsRecyclerViewFragment.restoreRecyclerViewLastPosition();
            }

            @Override
            public void onFailFetchingList(String message) {
                leadsRecyclerViewFragment.prompFailMessage(message);
            }
        });

    }

}
