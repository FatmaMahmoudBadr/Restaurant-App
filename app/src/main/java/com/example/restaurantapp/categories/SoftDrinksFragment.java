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

public class SoftDrinksFragment extends Fragment implements RecyclerViewInterface {

    private View drinksView;
    SqliteHelper mysql;
    ArrayList<MealModel> modelArrayList;
    MealsAdapter mealsAdapter;
    RecyclerView drinksRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        drinksView = inflater.inflate(R.layout.fragment_soft_drinks, container, false);

        mysql=new SqliteHelper(drinksView.getContext().getApplicationContext());
        modelArrayList=new ArrayList<>();
        drinksRecyclerView=drinksView.findViewById(R.id.drinksRV);
        modelArrayList=mysql.displayData("Family");
        mealsAdapter=new MealsAdapter(modelArrayList,drinksView.getContext().getApplicationContext(),this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(drinksView.getContext().getApplicationContext(),RecyclerView.VERTICAL,false);
        drinksRecyclerView.setLayoutManager(linearLayoutManager);
        drinksRecyclerView.setAdapter(mealsAdapter);

        return drinksView;
    }

    @Override
    public void onItemClick(int position) {

    }
}