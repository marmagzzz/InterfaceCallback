package io.github.marmagzzz.makepupp.activity.leadspackage;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import io.github.marmagzzz.makepupp.activity.leadspackage.controller.ListingController;
import io.github.marmagzzz.makepupp.activity.leadspackage.model.ListingModel;
import io.github.marmagzzz.makepupp.R;
import io.github.marmagzzz.makepupp.activity.leadspackage.RecyclerAdapter.LeadsAdapter;
import io.github.marmagzzz.makepupp.activity.leadspackage.view.LeadsRecyclerViewFragment;
import io.github.marmagzzz.makepupp.my_interface.FetchingInterface;
import io.github.marmagzzz.makepupp.my_interface.TimerInterface;
import io.github.marmagzzz.makepupp.timer.TimeTaskManager;

import java.util.concurrent.Callable;

public class Leads extends AppCompatActivity {

    private String userId;
    private Intent intent;

    private ListingModel listingModel;

    private LeadsRecyclerViewFragment leadsRecyclerViewFragment;

    private ListingController listingController;

    private TimeTaskManager timeTaskManager;

    private TextView textViewProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lead);

        intent = getIntent();
        userId = intent.getStringExtra("userId");

        textViewProgress = findViewById(R.id.textview_progress);

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

        timeTaskManager = new TimeTaskManager();

        timeTaskManager.start(new TimeTaskManager.timerProgress() {
            @Override
            public void onGoing(int progress) {
                System.out.println(progress);
            }

            @Override
            public void onStop(Exception e) {
                System.out.println(e);
            }
        }, new Runnable() {
            @Override
            public void run() {
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
                        timeTaskManager.stop();
                        leadsRecyclerViewFragment.prompFailMessage(message);
                    }
                });
            }
        });

//        timeTaskManager = new TimeTaskManager(new Runnable() {
//            @Override
//            public void run() {
//                listingController.fetchListing(new FetchingInterface() {
//                    @Override
//                    public void onSuccessFetchingList(LeadsAdapter leadsAdapter) {
//                        //Save state position of recycler view
//                        leadsRecyclerViewFragment.saveRecyclerViewCurrentPosition();
//
//                        //Set adapter for recycler view
//                        leadsRecyclerViewFragment.setListingAdapter(leadsAdapter);
//
//                        //Retaining position of view for recycler view
//                        leadsRecyclerViewFragment.restoreRecyclerViewLastPosition();
//
//                    }
//
//                    @Override
//                    public void onFailFetchingList(String message) {
//                        timeTaskManager.stop();
//                        leadsRecyclerViewFragment.prompFailMessage(message);
//                    }
//                });
//            }
//        });

//        timeTaskManager.start(new TimeTaskManager.timerProgress() {
//            @Override
//            public void onGoing(int progress) {
//                Log.v("PROGRESS", String.valueOf(progress));
//            }
//
//            @Override
//            public void onStop(final Exception e) {
////                Leads.this.runOnUiThread(new Runnable() {
////                    @Override
////                    public void run() {
////                        textViewProgress.setText(e.getMessage());
////                    }
////                });
//            }
//        });

    }

}
