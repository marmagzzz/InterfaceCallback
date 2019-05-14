package io.github.marmagzzz.makepupp.my_interface;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginApi {

    @POST("/manual/login")
    @FormUrlEncoded
    Call<model.User> manualLogin(@Field("emailAddress") String emailAddress,
                                 @Field("password") String password);

}
