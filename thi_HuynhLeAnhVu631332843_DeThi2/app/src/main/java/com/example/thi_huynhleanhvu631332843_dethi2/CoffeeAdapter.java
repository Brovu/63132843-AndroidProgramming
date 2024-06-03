package com.example.thi_huynhleanhvu631332843_dethi2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder> {

    private List<Coffee> coffeeList;

    public CoffeeAdapter(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_coffe, parent, false);
        return new CoffeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {
        Coffee coffee = coffeeList.get(position);
        holder.coffeeName.setText(coffee.getName());
        holder.coffeeAddress.setText(coffee.getAddress());
        holder.coffeeImage.setImageResource(coffee.getImageResId());
    }

    @Override
    public int getItemCount() {
        return coffeeList.size();
    }

    static class CoffeeViewHolder extends RecyclerView.ViewHolder {
        ImageView coffeeImage;
        TextView coffeeName;
        TextView coffeeAddress;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);
            coffeeImage = itemView.findViewById(R.id.coffee_image);
            coffeeName = itemView.findViewById(R.id.coffee_name);
            coffeeAddress = itemView.findViewById(R.id.coffee_address);
        }
    }
}
