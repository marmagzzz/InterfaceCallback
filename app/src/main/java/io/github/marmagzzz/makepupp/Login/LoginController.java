package io.github.marmagzzz.makepupp.Login;

import retrofit2.Response;

public class LoginController {

    private LoginModel loginModel;

    public LoginController(String username, String password) {
        this.loginModel = new LoginModel(username, password);
    }

    public void manualLogin(final RequestLoginInterface requestLoginInterface){
        loginModel.httpLogin(new RequestLoginInterface() {
            @Override
            public void onSuccessLogin(String message, Response<model.User> response) {
                requestLoginInterface.onSuccessLogin(message, response);
            }

            @Override
            public void onFailLogin(String message) {
                requestLoginInterface.onFailLogin(message);
            }
        });
    }

}
