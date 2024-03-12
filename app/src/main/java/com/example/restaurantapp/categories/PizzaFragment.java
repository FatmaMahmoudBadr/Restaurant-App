package com.example.restaurantapp.categories;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restaurantapp.ItemActivity;
import com.example.restaurantapp.R;
import com.example.restaurantapp.SqliteHelper;
import com.example.restaurantapp.home.MealModel;
import com.example.restaurantapp.home.MealsAdapter;

import java.util.ArrayList;

public class PizzaFragment extends Fragment implements RecyclerViewInterface{
    private View pizzaView;
    SqliteHelper mysql;
    ArrayList<MealModel> modelArrayList;
    MealsAdapter mealsAdapter;
    RecyclerView pizzaRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        pizzaView = inflater.inflate(R.layout.fragment_pizza, container, false);

        mysql=new SqliteHelper(pizzaView.getContext().getApplicationContext());
        modelArrayList=new ArrayList<>();
        pizzaRecyclerView=pizzaView.findViewById(R.id.pizzaRV);
        modelArrayList=mysql.displayData("Pizza");
        mealsAdapter=new MealsAdapter(modelArrayList,pizzaView.getContext().getApplicationContext(),this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(pizzaView.getContext().getApplicationContext(),RecyclerView.VERTICAL,false);
        pizzaRecyclerView.setLayoutManager(linearLayoutManager);
        pizzaRecyclerView.setItemAnimator(new DefaultItemAnimator());
        pizzaRecyclerView.setAdapter(mealsAdapter);

        return pizzaView;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), ItemActivity.class);
        intent.putExtra("name",modelArrayList.get(position).getName());
        intent.putExtra("image",modelArrayList.get(position).getImage());
        intent.putExtra("price",modelArrayList.get(position).getPrice());
        startActivity(intent);

    }
}