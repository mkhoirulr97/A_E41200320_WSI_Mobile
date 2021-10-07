package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormatSymbols;

public class MainActivity extends AppCompatActivity {

    //mendeklarasikan sebuah variabel
    ListView ListMatkul; //membuat komponen ListView dengan nama variabel "ListMatkul"
    Spinner spinner; //membuat komponen spinner dengan nama variabel "spinner"
    String[] prodi = new String[]{ //membuat array yang menampung data prodi di jurusan Teknologi Informasi
            "Teknik Komputer",
            "Manajemen Informatika",
            "Teknik Informatika",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //method ini akan memanggil layout activity_main

        AutoCompleteTextView edittext = findViewById(R.id.prodi); //akan memanggil pada activity_main berdasarkan id
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prodi); //menampilkan list item pada layout activity main berdasarkan data prodi ketika diketikkan huruf
        edittext.setAdapter(adapters); //men-set edittext yang sudah dibuat kedalam adapter

        ListMatkul = findViewById(R.id.ListMatkul); //memanggil pada activity_main berdasarkan id
        String[] matkul =  { //membuat array yang berisi mengenai mata kuliah program studi Teknik Informatika semester 3
                "Interaksi Manusia dan Komputer",
                "Immerdiate English",
                "Workshop Mobile Applications",
                "Workshop Sistem Informasi Berbasis Web",
                "Workshop Kualitas Perangkat lunak",
                "Perencanaan Kualitas Perangkat Lunak",
                "Struktur Data"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, matkul); //mmenampilkan list item pada layout activity main berdasarkan data matkul yang ada pada array
        ListMatkul.setAdapter(adapter); //menampilkan atau set list matkul sesuai adapter yang sudah dideklarasikan diatas

        //method ini berfungsi untuk memberikan action click
        ListMatkul.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //karena ingin memberikan action klik pada list matkul maka code program yang digunakan seperti dibawah ini, jadi ketika dipilih, atau di klik maka akan muncul telah memilih mata kuliah tersebut
                Toast.makeText(getApplicationContext(), "Anda memilih mata kuliah: "+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //method ini berfungsi untuk menampilkan list golongan dengan metode spinner
    public void prodi(View view) {
        @SuppressLint("WrongViewCast") TextView golonganT = findViewById(R.id.golongan); //akan menampilkan berdasarkan layout activity_main berdasarkan id
        spinner = findViewById(R.id.golongan); //akan menampilkan berdasarkan layout activity_main berdasarkan id
        String golongan = String.valueOf(spinner.getSelectedItem()); //ini akan menampung item yang telah dipilih dalam spinner
        golonganT.setText(golongan); //akan senampilkan item yang telah dipilih berdasarkan spinner
    };
}