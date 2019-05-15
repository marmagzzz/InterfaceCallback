package io.github.marmagzzz.makepupp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import io.github.marmagzzz.makepupp.Login.LoginController;
import io.github.marmagzzz.makepupp.Login.RequestLoginInterface;
import io.github.marmagzzz.makepupp.R;
import io.github.marmagzzz.makepupp.objectclass.Login;
import io.github.marmagzzz.makepupp.my_interface.LoginInterface;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private LoginController loginController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et_emailAdd = findViewById(R.id.login_edittext_email);
        final EditText et_password = findViewById(R.id.login_edittext_password);
        Button btn_login = findViewById(R.id.login_button);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginController = new LoginController(
                    et_emailAdd.getText().toString(),
                    et_password.getText().toString());

                loginController.manualLogin(new RequestLoginInterface() {
                    @Override
                    public void onSuccessLogin(String message, Response<model.User> response) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( getApplicationContext(), Leads.class );
                        intent.putExtra("userId", response.body().getUserId().toString());
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        getApplicationContext().startActivity(intent);
                    }

                    @Override
                    public void onFailLogin(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

}
