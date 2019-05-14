package io.github.marmagzzz.makepupp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import io.github.marmagzzz.makepupp.R;
import io.github.marmagzzz.makepupp.objectclass.Login;
import io.github.marmagzzz.makepupp.my_interface.LoginInterface;

public class MainActivity extends AppCompatActivity {

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
                Login newUser = new Login(
                        et_emailAdd.getText().toString(),
                        et_password.getText().toString(),
                        getApplicationContext());
                newUser.login(new LoginInterface() {
                    @Override
                    public void onSucceed(String result) {
                        Toast.makeText(getApplicationContext(), "Logging in succeed.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailed(String result) {
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

}
