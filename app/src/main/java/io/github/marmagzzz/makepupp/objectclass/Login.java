package io.github.marmagzzz.makepupp.objectclass;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import io.github.marmagzzz.makepupp.activity.Leads;
import io.github.marmagzzz.makepupp.my_interface.LoginApi;
import io.github.marmagzzz.makepupp.my_interface.LoginInterface;
import io.github.marmagzzz.makepupp.network.RetrofitInstance;
import model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login {

    private String username, password;
    private Context mContext;
    private LoginApi loginApi;

    public Login(String username, String password, Context mContext) {
        this.username = username;
        this.password = password;
        this.mContext = mContext;
    }

    public void login(final LoginInterface loginInterface){
        loginApi = RetrofitInstance.getRetrofitInstance().create(LoginApi.class);
        Call<model.User> call = loginApi.manualLogin(username, password);

            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.isSuccessful()){
                        if(response.body().getStatus().booleanValue()){
                            loginInterface.onSucceed(response.body().toString());
                            Intent intent = new Intent(mContext, Leads.class);
                            intent.putExtra("userId", response.body().getUserId().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            mContext.startActivity(intent);
                        }
                        else{
                            loginInterface.onFailed("Failed to login.");
                        }
                    }
                    else{
                        loginInterface.onFailed("Failed to login.");
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    loginInterface.onFailed("Failed to login.");
                }
            });
    }
}
