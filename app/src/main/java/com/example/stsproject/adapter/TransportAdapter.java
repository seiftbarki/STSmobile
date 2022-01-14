package com.example.stsproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stsproject.R;
import com.example.stsproject.model.Transport;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TransportAdapter extends RecyclerView.Adapter<TransportViewHolder> {

    Context context;
    List<Transport> list;

    public TransportAdapter(Context context, List<Transport> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TransportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transport,parent,false);
        return new TransportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransportViewHolder holder, int position) {
        holder.nom.setText(list.get(position).getNom());
        holder.num.setText(String.valueOf(list.get(position).getNum()));
        Picasso.with(context).load(list.get(position).getImageURL())
                .placeholder(R.drawable.load)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
