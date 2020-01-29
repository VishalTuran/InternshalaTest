package com.csemaster.internshalatest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FruitRecycler extends RecyclerView.Adapter<FruitRecycler.FruitViewHolder> {
    ArrayList<String> fruitNames;
    ArrayList<Integer> fruitImages;
    boolean isChecked=false;
    int lastPos=0;

    public FruitRecycler(ArrayList<String> fruitNames, ArrayList<Integer> fruitImages) {
        this.fruitNames = fruitNames;
        this.fruitImages = fruitImages;
    }

    @NonNull
    @Override
    public FruitRecycler.FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vh= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlefruitlayout,parent,false);
        return new FruitViewHolder(vh);
    }

    @Override
    public void onBindViewHolder(@NonNull final FruitRecycler.FruitViewHolder holder, final int position) {
        holder.imageView.setImageResource(fruitImages.get(position));
        holder.textView.setText(fruitNames.get(position));
        holder.checkImageView.setVisibility(View.GONE);

        if(position == lastPos) {
            holder.checkImageView.setVisibility(View.VISIBLE); //Define the re
        } else {
            holder.checkImageView.setVisibility(View.GONE); //Define the re

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int prevPos = lastPos;
                lastPos = position;
                notifyItemChanged(prevPos);
                notifyItemChanged(lastPos);
            }
        });



    }

    @Override
    public int getItemCount() {
        return fruitImages.size();
    }

    public class FruitViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        ImageView checkImageView;
        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.fruitName);
            imageView=itemView.findViewById(R.id.fruitImage);
            checkImageView=itemView.findViewById(R.id.tickIcon);
        }
    }
}
