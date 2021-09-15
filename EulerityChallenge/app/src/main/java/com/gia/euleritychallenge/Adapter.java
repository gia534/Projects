package com.gia.euleritychallenge;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder>{
    private List<Bitmap> images;

    public Adapter(List<Bitmap> images) {
        this.images =  images;
    }

    @NonNull
    @Override
    public Adapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.imagelistitems, parent, false);

        return new AdapterViewHolder(itemView);
    }

    // Connecting the data to the view holder
    @Override
    public void onBindViewHolder(@NonNull Adapter.AdapterViewHolder holder, int position) {
        Bitmap currentImage = images.get(position);
        holder.imageView.setImageBitmap(currentImage);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;
        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
        }
    }
}