package com.ayush.travelapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ayush.travelapp.Domains.Cast;
import com.ayush.travelapp.R;

import java.util.ArrayList;

public class CastListAdapter extends RecyclerView.Adapter<CastListAdapter.ViewHolder> {
    ArrayList<Cast> casts;
    Context context;

    public CastListAdapter(ArrayList<Cast> casts) {
        this.casts = casts;
    }

    @NonNull
    @Override
    public CastListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();
        View inflate= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_actors,viewGroup,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CastListAdapter.ViewHolder viewHolder, int i) {
        Glide.with(context)
                .load(casts.get(i).getPicUrl())
                .into(viewHolder.pic);

        viewHolder.nameTxt.setText(casts.get(i).getActor());
    }

    @Override
    public int getItemCount() {
        return casts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView pic;
        TextView nameTxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.itemImage);
            nameTxt=itemView.findViewById(R.id.nameTxt);
        }
    }
}
