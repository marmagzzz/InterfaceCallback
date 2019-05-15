package io.github.marmagzzz.makepupp.Listing;

import retrofit2.Response;

import java.util.ArrayList;

public interface ListingInterface {

    void onSuccess(Response<model.LeadsModel> leadsModelResponse, int page);

    void onFail(String message, int page);

    void onMaxPage(String message, int page);
}
