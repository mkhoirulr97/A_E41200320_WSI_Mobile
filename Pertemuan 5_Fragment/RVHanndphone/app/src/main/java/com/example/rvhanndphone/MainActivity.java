package com.example.rvhanndphone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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

    String[] handphone = new String[]{ //membuat array yang menampung handphone
            "Apple",
            "Redmi",
            "Oppo",
            "Vivo",
            "Samsung"
    };

    BottomNavigationView bottomNavigationView; //membuat penampung untuk bottomNavigationView

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

        AutoCompleteTextView edittext = findViewById(R.id.handphone); //akan memanggil pada activity_main berdasarkan id
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, handphone); //menampilkan list item pada layout activity main berdasarkan data handphone ketika diketikkan huruf
        edittext.setAdapter(adapters); //men-set edittext yang sudah dibuat kedalam adapter

        bottomNavigationView = findViewById(R.id.bottom_navigation);  //bootomNavigation View yang ada pada layout main Activity akan ditampung dalam variabel bottomNavigationView
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Chat()).commit(); //ini digunakan untuk set secara default ketika masuk kedalam suatu aplikasi
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { //mengecek suatu kondisi jika salah satu fragment dari bottomNavigation dipilih akan menjalankan perintah dibawah
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) { //menjalankan suatu perintah dari kondisi yang sudah di inisialisasikan diatas
                Fragment selectedFragment = null;
                switch (item.getItemId()){ //melakukan penentuan suatu kondisi
                    case R.id.chats:  //jika fragment yang dipilih
                        selectedFragment = new Chat(); //akan menampilkan layout chat berdasarkan id yang dipanggil dari fragment
                        break; //kemudian lakukan break
                    case R.id.status: //jika fragment yang dipilih
                        selectedFragment = new Status(); //akan menampilkan layout status berdasarkan id yang dipanggil dari fragment
                        break; //kemudian lakukan break
                    case  R.id.calls: //jika fragment yang dipilih
                        selectedFragment = new Calls(); //akan menampilkan layout calls berdasarkan id yang dipanggil dari fragment
                        break; //kemudian lakukan break
                    case R.id.home: //jika fragment yang dipilih
                        selectedFragment = new Home(); //akan menampilkan layout home berdasarkan id yang dipanggil dari fragment
                        break; //kemudian lakukan break
                    case R.id.acount: //jika fragment yang dipilih
                        selectedFragment = new Acount(); //akan menampilkan layout acount berdasarkan id yang dipanggil dari fragment
                        break; //kemudian lakukan break
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit(); //ini digunakan untuk mereplace fragment sebelumnya dengan fragment yang sedang dipilih saat ini

            return true; //melakukan kembalian
            }
        });
    }
}