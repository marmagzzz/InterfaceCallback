package io.github.marmagzzz.makepupp.objectclass;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import io.github.marmagzzz.makepupp.my_interface.LeadsApi;
import io.github.marmagzzz.makepupp.my_interface.LeadsInterface;
import io.github.marmagzzz.makepupp.network.RetrofitInstance;
import model.LeadsModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeadsClass {

    private String userId;
    private Context mContext;

    private Retrofit retrofit;
    private LeadsApi leadsApi;
    private int page = 0;

    public LeadsClass(String userId, Context mContext) {
        this.userId = userId;
        this.mContext = mContext;
    }

    LeadsInterface leadsInterface;

    public void onGetLeads(LeadsInterface leadsInterface){
        this.leadsInterface = leadsInterface;
    }

    public void getLeads(final LeadsInterface leadsInterface)  {
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
                        Toast.makeText(mContext, "New data loaded. Page: " + page, Toast.LENGTH_SHORT).show();
                        leadsInterface.onSuccess(response.body().getLeads().getRecords(), page);
                        page += 1;
                    }
                    else{//max page
                        leadsInterface.onMaxPage("You reached max page.");
                    }
                }
                else{
                    leadsInterface.onFail("Failed to load. Page: " + page, page);
                }
            }

            @Override
            public void onFailure(Call<LeadsModel> call, Throwable t) {
                leadsInterface.onFail("Failed to load. Page: " + page, page);
            }
        });

    }
}
