package com.example.rvhanndphone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    //membuat sebuah variabel
    ImageView mainImageView; //membuat komponen ImageView dengan nama variabel mainImageView
    TextView title, description; //membuat komponen TextView dengan nama variabel title, dan descrription
    String data1, data2; //membuat variabel bertipe data String dengan nama variabel data1 dan data2
    int image; //membuat variabel int dengan nama variabel image bertipe data integer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);// ini akan memanggil dari layout activity_second

        mainImageView = findViewById(R.id.mainimageView); //pada variabel ini akan menampung image dengan metode memanggil berdasarkan id
        title = findViewById(R.id.title); //pada variabel ini akan menampung title dengan metode memanggil berdasarkan id
        description = findViewById(R.id.description); //pada variabel ini akan menampung description dengan metode memanggil berdasarkan id

        getData(); //akan memanggil mehtod getData()
        setData(); //akan memanggil mehtod setData()
    }

    //pada method ini akan mengambil data
    private void getData(){
        if(getIntent().hasExtra("image") && getIntent().hasExtra("data1" )&& getIntent().hasExtra("data2")){ //membuat sebuah kondisi dimana jika image, title dan description sama dengan yang diinputkan maka akan membuat sebuauh aksi seperti dibawah
            data1 = getIntent().getStringExtra("data1"); //aksi akan menampung dalam variabel data1
            data2 = getIntent().getStringExtra("data2"); //aksi akan menampung dalam variabel data2
            image = getIntent().getIntExtra("image", 1); //aksi akan menampung dalam variabel image
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show(); //jika tidak sesuai kondisi diatas maka akan menampilkan No data.
        }
    }
    private void setData(){
        title.setText(data1); //akan menampilkan title berdasarkan apa yang ditampung di variabel data1
        description.setText(data2); //akan menampilkan description berdasarkan apa yang ditampung di variabel data2
        mainImageView.setImageResource(image); //akan menampilkan mainImageView berdasarkan apa yang ditampung di variabel image
    }
}