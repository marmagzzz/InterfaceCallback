package io.github.marmagzzz.makepupp.Login;

import retrofit2.Response;

public interface RequestLoginInterface {

    void onSuccessLogin(String message, Response<model.User> response);

    void onFailLogin(String message);

}
