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

public class ExtrasFragment extends Fragment implements RecyclerViewInterface {

    private View extrasView;
    SqliteHelper mysql;
    ArrayList<MealModel> modelArrayList;
    MealsAdapter mealsAdapter;
    RecyclerView extrasRecyclerView;


      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        extrasView = inflater.inflate(R.layout.fragment_extras, container, false);

          mysql=new SqliteHelper(extrasView.getContext().getApplicationContext());
          modelArrayList=new ArrayList<>();
          extrasRecyclerView=extrasView.findViewById(R.id.extrasRV);
          modelArrayList=mysql.displayData("Family");
          mealsAdapter=new MealsAdapter(modelArrayList,extrasView.getContext().getApplicationContext(),this);
          LinearLayoutManager linearLayoutManager = new LinearLayoutManager(extrasView.getContext().getApplicationContext(),RecyclerView.VERTICAL,false);
          extrasRecyclerView.setLayoutManager(linearLayoutManager);
          extrasRecyclerView.setAdapter(mealsAdapter);

        return extrasView;
      }

    @Override
    public void onItemClick(int position) {

    }
}