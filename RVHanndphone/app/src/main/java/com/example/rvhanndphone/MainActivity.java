package com.example.rvhanndphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //mendeklarasikan sebuah variabel
    RecyclerView recyclerView; //membuat sebuah komponen RecyclerView dengan nama variabel "recyclerview"
    String s1[], s2[]; //membuat sebuah array dua dimensi
    int image[] = {//membuat array yang menampung daftar gambar yang akan ditampillkan dengan tipe data integer
            R.drawable.apple,
            R.drawable.redmi,
            R.drawable.oppo,
            R.drawable.vivo,
            R.drawable.samsung};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //ini akan memanggil pada layout activity_main

        recyclerView = findViewById(R.id.recycleView); //sebuah variabel yang akan menampung recycleview berdasarkan layoud activity_main dengan memanggil id nya
        s1 = getResources().getStringArray(R.array.handphone); //variabel s1 akan menampung data array handphone yang sudah dibuat pada string.xml
        s2 = getResources().getStringArray(R.array.deskripsi); //variabel s2 akan menampung data array deskripsi yang sudah dibuat pada string.xml

        Adapter adapter = new Adapter(this, s1, s2, image); //akan menghubungkan variabel ke adapter
        recyclerView.setAdapter(adapter); //kemudian akan men-set recyclerview dengan adapter yang sudah dihubungkan diatas
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}