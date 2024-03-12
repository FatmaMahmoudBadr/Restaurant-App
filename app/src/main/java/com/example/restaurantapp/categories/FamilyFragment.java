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

public class FamilyFragment extends Fragment implements RecyclerViewInterface{

    private View familyView;
    SqliteHelper mysql;
    ArrayList<MealModel> modelArrayList;
    MealsAdapter mealsAdapter;
    RecyclerView familyRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        familyView = inflater.inflate(R.layout.fragment_family, container, false);

        mysql=new SqliteHelper(familyView.getContext().getApplicationContext());
        modelArrayList=new ArrayList<>();
        familyRecyclerView=familyView.findViewById(R.id.familyRV);
        modelArrayList=mysql.displayData("Family");
        mealsAdapter=new MealsAdapter(modelArrayList,familyView.getContext().getApplicationContext(),this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(familyView.getContext().getApplicationContext(),RecyclerView.VERTICAL,false);
        familyRecyclerView.setLayoutManager(linearLayoutManager);
        familyRecyclerView.setItemAnimator(new DefaultItemAnimator());
        familyRecyclerView.setAdapter(mealsAdapter);

        return familyView;
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