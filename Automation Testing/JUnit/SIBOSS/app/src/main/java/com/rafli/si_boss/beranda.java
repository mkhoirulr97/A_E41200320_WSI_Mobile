package com.rafli.si_boss;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class beranda extends AppCompatActivity {

    Button BtnKeluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beranda);

        BtnKeluar = (Button) findViewById(R.id.BtnKeluar);

        BtnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //perintah untuk mengakhiri aplikasi
                finish();
            }
        });

    }
}
