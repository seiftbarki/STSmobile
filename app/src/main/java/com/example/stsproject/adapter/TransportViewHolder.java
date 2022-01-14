package com.example.stsproject.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stsproject.R;

public class TransportViewHolder extends RecyclerView.ViewHolder {
    TextView nom,num;
    ImageView image;


    public TransportViewHolder(@NonNull View itemView) {
        super(itemView);
        nom=itemView.findViewById(R.id.edit_nom);
        num=itemView.findViewById(R.id.edit_num);
        image=itemView.findViewById(R.id.image);

    }
}
