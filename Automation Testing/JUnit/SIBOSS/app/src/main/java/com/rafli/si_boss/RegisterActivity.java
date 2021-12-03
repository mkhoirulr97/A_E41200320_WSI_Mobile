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
import com.rafli.si_boss.model.login.register.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText EtUsernameDaftar, EtNamaLengkapDaftar, EtPasswordDaftar;
    Button BtnDaftar;
    TextView TvLogin;
    String Username, Password, Name;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        EtUsernameDaftar = findViewById(R.id.EtUsernameDaftar);
        EtPasswordDaftar = findViewById(R.id.EtPasswordDaftar);
        EtNamaLengkapDaftar = findViewById(R.id.EtNamaLengkapDaftar);
        BtnDaftar = findViewById(R.id.BtnDaftar);
        BtnDaftar.setOnClickListener(this);

        TvLogin = findViewById(R.id.TvLogin);
        TvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtnDaftar:
                Username = EtUsernameDaftar.getText().toString();
                Password = EtPasswordDaftar.getText().toString();
                Name = EtNamaLengkapDaftar.getText().toString();
                register(Username, Password, Name);
                break;
            case R.id.TvLogin:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void register(String username, String password, String name) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Register> call = apiInterface.registerResponse(username, password, name);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    Toast.makeText( RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
