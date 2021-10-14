package com.example.rvhanndphone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //membuat sebuah variabel
    String data1[], data2[]; //membuat array dua dimensi
    int image[]; //membuat variabel yang menampung image
    Context context;

    public Adapter(Context ct, String s1[], String s2[], int img[]) { //membuat adapter dengan memasukkan nilai nantinya
        context = ct;
        data1 = s1;
        data2 = s2;
        image = img;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context); //membuat variabel inflater dengan set data berdasarkan context
        View view = inflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view); //mengembalikan nilai
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text1.setText(data1[position]); //men-set data berdasarkan posisi
        holder.text2.setText(data2[position]); //men-set data berdasarkan posisi
        holder.images.setImageResource(image[position]); //men-set data berdasarkan posisi

        holder.mainLayout.setOnClickListener(new View.OnClickListener() { //akan meembarika action jika di klik
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("data1", data1[position]);//men-set data berdasarkan posisi
                intent.putExtra("data2", data2[position]);//men-set data berdasarkan posisi
                intent.putExtra("image", image[position]);//men-set data berdasarkan posisi
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //deklarasikan variabel
        TextView text1, text2;
        ImageView images;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.HPView); //akan menampung ke variabel berdasarkan id yang didapat dari layout activity_main
            text2 = itemView.findViewById(R.id.DecView);  //akan menampung ke variabel berdasarkan id yang didapat dari layout activity_main
            images = itemView.findViewById(R.id.imageView);  //akan menampung ke variabel berdasarkan id yang didapat dari layout activity_main
            mainLayout = itemView.findViewById(R.id.mainLayout);  //akan menampung ke variabel berdasarkan id yang didapat dari layout activity_main
        }
    }
}
