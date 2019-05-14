package io.github.marmagzzz.makepupp.my_interface;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LeadsApi {

    @GET("/web/get-list/{userId}/{page}")
    Call<model.LeadsModel> getLeads(@Path("userId") String userId,
                                    @Path("page") int page);

}
