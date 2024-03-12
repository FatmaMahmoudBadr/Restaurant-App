package com.example.restaurantapp.categories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restaurantapp.R;
import com.example.restaurantapp.SqliteHelper;
import com.example.restaurantapp.home.MealModel;
import com.example.restaurantapp.home.MealsAdapter;

import java.util.ArrayList;

public class DessertsFragment extends Fragment implements RecyclerViewInterface{

    private View dessertsView;
    SqliteHelper mysql;
    ArrayList<MealModel> modelArrayList;
    MealsAdapter mealsAdapter;
    RecyclerView dessertsRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        dessertsView = inflater.inflate(R.layout.fragment_desserts, container, false);

        mysql = new SqliteHelper(dessertsView.getContext().getApplicationContext());
        modelArrayList = new ArrayList<>();
        dessertsRecyclerView = dessertsView.findViewById(R.id.dessertsRV);
        modelArrayList = mysql.displayData("Family");
        mealsAdapter = new MealsAdapter(modelArrayList, dessertsView.getContext().getApplicationContext(),this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(dessertsView.getContext().getApplicationContext(), RecyclerView.VERTICAL, false);
        dessertsRecyclerView.setLayoutManager(linearLayoutManager);
        dessertsRecyclerView.setAdapter(mealsAdapter);

        return dessertsView;
    }

    @Override
    public void onItemClick(int position) {

    }
}