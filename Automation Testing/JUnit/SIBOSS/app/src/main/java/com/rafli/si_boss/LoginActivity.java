package com.rafli.si_boss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rafli.si_boss.api.ApiClient;
import com.rafli.si_boss.api.ApiInterface;
import com.rafli.si_boss.model.login.register.Login;
import com.rafli.si_boss.model.login.register.LoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText EtUsernameLogin, EtPasswordLogin;
    Button BtnLogin;
    String Username, Password;
    TextView TvRegister;
    ApiInterface apiInterface;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EtUsernameLogin = findViewById(R.id.EtUsernameLogin);
        EtPasswordLogin = findViewById(R.id.EtPasswordLogin);

        BtnLogin = findViewById(R.id.BtnLogin);
        BtnLogin.setOnClickListener(this);

        TvRegister = findViewById(R.id.TvDaftar);
        TvRegister.setOnClickListener(this);
    }
//ketika di click pindah halaman lain
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtnLogin:
                Username = EtUsernameLogin.getText().toString();
                Password = EtPasswordLogin.getText().toString();
                login(Username, Password);
                break;
            case R.id.TvDaftar:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void login(String username, String password) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Login> loginCall = apiInterface.loginResponse(username, password);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()){

                    // Untuk menyimpan sesi
                    sessionManager = new SessionManager(LoginActivity.this);
                    LoginData loginData = response.body().getLoginData();
                    sessionManager.createLoginSession(loginData);

                    // untuk pindah
                    Toast.makeText( LoginActivity.this, response.body().getLoginData().getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
