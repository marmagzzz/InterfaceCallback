package io.github.marmagzzz.makepupp.activity.leadspackage.RecyclerAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.github.marmagzzz.makepupp.R;

import java.util.ArrayList;

public class LeadsAdapter extends RecyclerView.Adapter<LeadsAdapter.LeadsViewHolder> {

    private ArrayList<model.Record> leadsList;

    public LeadsAdapter(ArrayList<model.Record> leadsList) {
        this.leadsList = leadsList;
    }

    @NonNull
    @Override
    public LeadsAdapter.LeadsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.lead_card, viewGroup, false);
        return new LeadsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadsAdapter.LeadsViewHolder leadsViewHolder, int i) {
        leadsViewHolder.tvLeadId.setText(i + " " + leadsList.get(i).getEmailAddress() + " " + leadsList.get(i).getFullName());
    }

    @Override
    public int getItemCount() {
        return leadsList.size();
    }

    class LeadsViewHolder extends RecyclerView.ViewHolder {

        TextView tvLeadId;

        public LeadsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLeadId = itemView.findViewById(R.id.lead_textview_lead_id);
        }

    }
}
