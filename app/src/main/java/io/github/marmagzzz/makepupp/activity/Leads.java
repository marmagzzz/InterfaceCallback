package io.github.marmagzzz.makepupp.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import io.github.marmagzzz.makepupp.R;
import io.github.marmagzzz.makepupp.adapter.LeadsAdapter;
import io.github.marmagzzz.makepupp.my_interface.LeadsApi;
import io.github.marmagzzz.makepupp.my_interface.LeadsInterface;
import io.github.marmagzzz.makepupp.network.RetrofitInstance;
import io.github.marmagzzz.makepupp.objectclass.LeadsClass;
import model.LeadsModel;
import model.Record;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Leads extends AppCompatActivity {

    private String userId;
    private Intent intent;
    private int currentPage;
    private int failedPage;

    private boolean shouldContinue = true;

    private RecyclerView recyclerView;
//    private RecyclerView.Adapter rAdapter;
    private LeadsAdapter leadsAdapter;

    private ArrayList<model.Record> leadsModelsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lead);

        intent = getIntent();
        userId = intent.getStringExtra("userId");

        Retrofit retrofit;

        leadsModelsArrayList = new ArrayList<>();

        final LeadsClass leadsClass = new LeadsClass(userId, Leads.this);

        getLeads(leadsClass);

    }

    private void getLeads(final LeadsClass leadsClass) {
        leadsClass.getLeads(new LeadsInterface() {

            @Override
            public void onMaxPage(String message) {
                Toast.makeText(Leads.this, message, Toast.LENGTH_SHORT).show();
                shouldContinue = false;
            }

            @Override
            public void onSuccess(ArrayList<Record> resultArrayList, int page) {
                currentPage = page;
                leadsModelsArrayList.addAll(resultArrayList);
                generateLeadsList(leadsModelsArrayList);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        getLeads(leadsClass);
                    }
                },10000);
            }

            @Override
            public void onFail(String message, int page) {
                failedPage = page;
                Toast.makeText(Leads.this, message, Toast.LENGTH_SHORT).show();
                shouldContinue = false;
            }
        });
    }

    private void generateLeadsList(ArrayList<model.Record> leadArrayList){
        recyclerView = findViewById(R.id.lead_recyclerview);
        recyclerView.setHasFixedSize(true);
        leadsAdapter = new LeadsAdapter(leadArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Leads.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(leadsAdapter);
    }
}
