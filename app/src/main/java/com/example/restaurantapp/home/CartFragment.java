package com.example.restaurantapp.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restaurantapp.R;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    private View cartView;
    ArrayList<MealModel> modelArrayList;
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        cartView= inflater.inflate(R.layout.fragment_cart, container, false);

        return  cartView;
        }
}