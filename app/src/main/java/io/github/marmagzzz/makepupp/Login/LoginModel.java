package io.github.marmagzzz.makepupp.Login;

import android.content.Intent;
import io.github.marmagzzz.makepupp.activity.Leads;
import io.github.marmagzzz.makepupp.my_interface.LoginApi;
import io.github.marmagzzz.makepupp.network.RetrofitInstance;
import model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel {

    private String username;
    private String password;
    private LoginApi loginApi;

    LoginModel(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void httpLogin(final RequestLoginInterface requestLoginInterface) {
        this.loginApi = RetrofitInstance.getRetrofitInstance().create(LoginApi.class);
        Call<model.User> call = loginApi.manualLogin(username, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    if(response.body().getStatus()){
                        requestLoginInterface.onSuccessLogin("Login succeed.", response);
                    }
                    else{
                        requestLoginInterface.onFailLogin("Failed to login. Wrong email or password.");
                    }
                }
                else{
                    requestLoginInterface.onFailLogin("Failed request to server. " + response.message() + " Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                requestLoginInterface.onFailLogin("Failed to login. " + t.getMessage());
            }
        });
    }
}
