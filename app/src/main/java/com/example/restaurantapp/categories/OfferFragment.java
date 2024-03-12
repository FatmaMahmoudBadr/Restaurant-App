package com.example.restaurantapp.categories;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.restaurantapp.ItemActivity;
import com.example.restaurantapp.MainActivity;
import com.example.restaurantapp.R;
import com.example.restaurantapp.SqliteHelper;
import com.example.restaurantapp.home.MealModel;
import com.example.restaurantapp.home.MealsAdapter;

import java.util.ArrayList;

public class OfferFragment extends Fragment implements RecyclerViewInterface{
    private View offerView;
    SqliteHelper mysql;
    ArrayList<MealModel>modelArrayList;
    MealsAdapter mealsAdapter;
    RecyclerView offerRecyclerView;
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        offerView= inflater.inflate(R.layout.fragment_offer, container, false);

        mysql=new SqliteHelper(offerView.getContext().getApplicationContext());


        modelArrayList=new ArrayList<>();
        offerRecyclerView=offerView.findViewById(R.id.offerRV);
        modelArrayList=mysql.displayData("Offer");
        mealsAdapter=new MealsAdapter(modelArrayList,offerView.getContext().getApplicationContext(),this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(offerView.getContext().getApplicationContext(),RecyclerView.VERTICAL,false);
        offerRecyclerView.setLayoutManager(linearLayoutManager);
        offerRecyclerView.setAdapter(mealsAdapter);
        offerRecyclerView.setItemAnimator(new DefaultItemAnimator());
        return offerView;
   }


    @Override
    public void onItemClick(int position) {
       Intent intent = new Intent(getActivity(),ItemActivity.class);
        intent.putExtra("name",modelArrayList.get(position).getName());
        intent.putExtra("image",modelArrayList.get(position).getImage());
        intent.putExtra("price",modelArrayList.get(position).getPrice());
       startActivity(intent);

    }
}