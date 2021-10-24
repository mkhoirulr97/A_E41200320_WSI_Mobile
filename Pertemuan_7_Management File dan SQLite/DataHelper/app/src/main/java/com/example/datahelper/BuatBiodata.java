package com.example.datahelper;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatBiodata extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnSimpan, btnKembali;
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dbHelper = new DataHelper(this);
        text1 = findViewById(R.id.edit_text1);
        text2 = findViewById(R.id.edit_text2);
        text3 = findViewById(R.id.edit_text3);
        text4 = findViewById(R.id.edit_text4);
        text5 = findViewById(R.id.edit_text5);
        btnSimpan = findViewById(R.id.btn_simpan);
        btnKembali = findViewById(R.id.btn_kembali);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO biodata (no, nama, tgl, jk, alamat) values ('" +
                        text1.getText().toString() + "', '" +
                        text2.getText().toString() + "', '" +
                        text3.getText().toString() + "', '" +
                        text4.getText().toString() + "', '" +
                        text5.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}