package com.example.intentimp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //mendeklarasikan variabel untuk menampung data yang dimasukkan ke material edit text
    private EditText et1; //menampung nilai dari edittext yang berisikan nomor telepon
    private EditText et2; //menampung nilai dari edittext yang berisikan URL website

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1); //memasukkan nilai dari edit text berdasarkan id dari edittext
        et2 = (EditText) findViewById(R.id.et2); //memasukkan nilai dari edit text berdasarkan id dari edittext
    }

    //membuat method go to untuk memberikan aksi ketika button dipilih
    public void GoTo(View view) {
        switch (view.getId()){ //menggunakan percabangan karena menggunakan 2 button

            case R.id.button1: //button untuk kirim SMS jika terpenuhi sesuai id nya maka akan melakukan perintah dibawah
                Uri uri = Uri.parse("smsto:" + et1.getText().toString()); //mengambil nilai dari edittext kemudian dimasukkan kedalam variabel uri
                Intent i1 = new Intent(Intent.ACTION_SENDTO, uri); //memberikan action send to untuk membuka tab pesan
                i1.putExtra("sms_body", "ini latihan"); //memberikan nilai otomatis ketika berpindah ke tab yang lain
                if (i1.resolveActivity(getPackageManager()) != null){  //jika nilai yang dilakukan bernilai true atau ada isinya maka
                    startActivity(i1); //lakukan start activity
                }
                break;

            case R.id.button2: //button untuk kirim URL jika terpenuhi sesuai id nya maka akan melakukan perintah dibawah
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + et2.getText().toString()); //mengambil nilai dari edittext kemudian dimasukkan kedalam variabel uri
                Intent i2 = new Intent(Intent.ACTION_VIEW, gmmIntentUri); //memberikan action view untuk membuka tab browser
                if (i2.resolveActivity(getPackageManager()) != null){ //jika nilai yang dilakukan bernilai true atau ada isinya maka
                    startActivity(i2); //lakukan start activity
                }
                break;
        }
    }

    //method yang digunakan untuk langsung dapat membuka jendela lain berdasarkan URL website ketika menekan button
    public void ig(View view) {
        String url = "https://instagram.com" ; //variabel untuk menampung URL
        Intent bukabrowser = new Intent(Intent. ACTION_VIEW); //membuat action view untuk membuka jendela lain
        bukabrowser.setData(Uri. parse(url)); //ketika membuka browser akan langsugn mengisikan URL berdasarkan variabel uri
        startActivity(bukabrowser); //selanjutnya buka browser
    }

    //method yang digunakan untuk langsung dapat membuka jendela lain berdasarkan URL website ketika menekan button
    public void wa(View view) {
        String url = "https://whatsapp.com" ; //variabel untuk menampung URL
        Intent bukabrowser = new Intent(Intent. ACTION_VIEW); //membuat action view untuk membuka jendela lain
        bukabrowser.setData(Uri. parse(url)); //ketika membuka browser akan langsugn mengisikan URL berdasarkan variabel uri
        startActivity(bukabrowser); //selanjutnya buka browser
    }

    //method yang digunakan untuk langsung dapat membuka jendela lain berdasarkan URL website ketika menekan button
    public void yt(View view) {
        String url = "https://youtube.com" ; //variabel untuk menampung URL
        Intent bukabrowser = new Intent(Intent. ACTION_VIEW); //membuat action view untuk membuka jendela lain
        bukabrowser.setData(Uri. parse(url)); //ketika membuka browser akan langsugn mengisikan URL berdasarkan variabel uri
        startActivity(bukabrowser); //selanjutnya buka browser
    }

    //method yang digunakan untuk langsung dapat membuka jendela lain berdasarkan URL website ketika menekan button
    public void tele(View view) {
        String url = "https://telegram.com" ; //variabel untuk menampung URL
        Intent bukabrowser = new Intent(Intent. ACTION_VIEW); //membuat action view untuk membuka jendela lain
        bukabrowser.setData(Uri. parse(url)); //ketika membuka browser akan langsugn mengisikan URL berdasarkan variabel uri
        startActivity(bukabrowser); //selanjutnya buka browser
    }

    //method yang digunakan untuk langsung dapat membuka jendela lain ke layout yang dibuat ketika menekan button
    public void home(View view) {
        Intent home = new Intent(MainActivity.this, Tentang.class); //akan membuka layout tentang
        startActivity(home); //lakukan start activity
    }

    //method yang digunakan untuk langsung dapat membuka jendela lain ke layout yang dibuat ketika menekan button
    public void tentang(View view) {
        Intent tentang= new Intent(MainActivity.this, Tentang.class); //akan membuka layout tentang
        startActivity(tentang); //lakukan start activity
    }

    //method yang digunakan untuk langsung dapat membuka jendela lain ke layout yang dibuat ketika menekan button
    public void acount(View view) {
        Intent acount = new Intent(MainActivity.this, Tentang.class); //akan membuka layout tentang
        startActivity(acount); //lakukan start activity
    }
}