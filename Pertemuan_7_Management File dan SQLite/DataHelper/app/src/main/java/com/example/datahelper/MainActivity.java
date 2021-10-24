package com.example.datahelper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] daftar;
    ListView listView1;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbCenter;
    public static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn_buat);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BuatBiodata.class);
                startActivity(intent);
            }
        });

        ma = this;
        dbCenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = dbCenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int i=0; i<cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(1).toString();
        }
        listView1 = findViewById(R.id.list_view1);
        listView1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        listView1.setSelected(true);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selection = daftar[i];
                final CharSequence[] dialogitem = {"Lihat Biodata", "Update Biodata", "Hapus Biodata"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                Intent in = new Intent(getApplicationContext(), LihatBiodata.class);
                                in.putExtra("nama", selection);
                                startActivity(in);
                                break;
                            case 1:
                                Intent inte = new Intent(getApplicationContext(), UpdateBiodata.class);
                                inte.putExtra("nama", selection);
                                startActivity(inte);
                                break;
                            case 2:
                                SQLiteDatabase db = dbCenter.getWritableDatabase();
                                db.execSQL("DELETE FROM biodata WHERE nama = '" + selection + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter)listView1.getAdapter()).notifyDataSetInvalidated();
    }
}