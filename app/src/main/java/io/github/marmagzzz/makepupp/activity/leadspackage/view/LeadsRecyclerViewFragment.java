package io.github.marmagzzz.makepupp.activity.leadspackage.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;
import io.github.marmagzzz.makepupp.activity.leadspackage.RecyclerAdapter.LeadsAdapter;
import io.github.marmagzzz.makepupp.R;

public class LeadsRecyclerViewFragment extends Fragment {

    private RecyclerView listingRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Context container;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflating
        View rootView = inflater.inflate(R.layout.fragment_leads_recycler_view, container, false);

        //Referencing views to context
        this.listingRecyclerView = rootView.findViewById(R.id.leads_fragment_recyclerview);
        this.listingRecyclerView.setHasFixedSize(true);
        this.layoutManager = new LinearLayoutManager(rootView.getContext());
        this.listingRecyclerView.setLayoutManager(layoutManager);

        this.container = getActivity();

        return rootView;
    }

    public void setListingAdapter(LeadsAdapter leadsAdapter) {
        listingRecyclerView.setAdapter(leadsAdapter);
    }

    public void prompFailMessage(String message){
        Toast.makeText(container, message, Toast.LENGTH_LONG).show();
    }

}
