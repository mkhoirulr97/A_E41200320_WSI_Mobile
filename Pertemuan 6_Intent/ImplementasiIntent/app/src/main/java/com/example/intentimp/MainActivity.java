package com.example.intentimp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
    }

    public void GoTo(View view) {
        switch (view.getId()){

            case R.id.button1:
                Uri uri = Uri.parse("smsto:" + et1.getText().toString());
                Intent i1 = new Intent(Intent.ACTION_SENDTO, uri);
                i1.putExtra("sms_body", "ini latihan");
                if (i1.resolveActivity(getPackageManager()) != null){
                    startActivity(i1);
                }
                break;

            case R.id.button2:
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + et2.getText().toString());
                Intent i2 = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                if (i2.resolveActivity(getPackageManager()) != null){
                    startActivity(i2);
                }
                break;
        }
    }

    public void ig(View view) {
        String url = "https://instagram.com" ;
        Intent bukabrowser = new Intent(Intent. ACTION_VIEW);
        bukabrowser.setData(Uri. parse(url));
        startActivity(bukabrowser);
    }

    public void wa(View view) {
        String url = "https://whatsapp.com" ;
        Intent bukabrowser = new Intent(Intent. ACTION_VIEW);
        bukabrowser.setData(Uri. parse(url));
        startActivity(bukabrowser);
    }

    public void yt(View view) {
        String url = "https://youtube.com" ;
        Intent bukabrowser = new Intent(Intent. ACTION_VIEW);
        bukabrowser.setData(Uri. parse(url));
        startActivity(bukabrowser);
    }

    public void tele(View view) {
        String url = "https://telegram.com" ;
        Intent bukabrowser = new Intent(Intent. ACTION_VIEW);
        bukabrowser.setData(Uri. parse(url));
        startActivity(bukabrowser);
    }

    public void home(View view) {
        Intent home = new Intent(MainActivity.this, Tentang.class);
        startActivity(home);
    }

    public void tentang(View view) {
        Intent tentang= new Intent(MainActivity.this, Tentang.class);
        startActivity(tentang);
    }

    public void acount(View view) {
        Intent acount = new Intent(MainActivity.this, Tentang.class);
        startActivity(acount);
    }
}