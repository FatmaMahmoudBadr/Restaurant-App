package com.example.restaurantapp.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.ItemActivity;
import com.example.restaurantapp.R;
import com.example.restaurantapp.categories.RecyclerViewInterface;

import java.util.ArrayList;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.ViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    private ArrayList<MealModel>mealModelArrayList;
    private Context context;

    public MealsAdapter(ArrayList<MealModel> mealModelArrayList, Context context,RecyclerViewInterface recyclerViewInterface) {
        this.mealModelArrayList = mealModelArrayList;
        this.context = context;
        this.recyclerViewInterface=recyclerViewInterface;
    }

    @NonNull
    @Override
    public MealsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new ViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MealsAdapter.ViewHolder holder, int position) {
        MealModel model = mealModelArrayList.get(position);
        holder.textName.setText(model.getName());
        holder.textPrice.setText(String.valueOf(model.getPrice()));
        holder.icon.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        return mealModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textName,textPrice;
        private ImageView icon;

        public ViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            textName=(TextView)itemView.findViewById(R.id.textName);
            textPrice=(TextView)itemView.findViewById(R.id.textPrice);
            icon=(ImageView)itemView.findViewById(R.id.mealIcon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface!=null){
                        int pos=getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }

                    }
                }
            });
        }


    }

}
