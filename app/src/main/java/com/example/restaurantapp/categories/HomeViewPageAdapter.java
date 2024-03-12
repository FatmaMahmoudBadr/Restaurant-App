package com.example.restaurantapp.categories;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class HomeViewPageAdapter extends FragmentStatePagerAdapter {

    public HomeViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public HomeViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new OfferFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new PizzaFragment();
            case 3:
                return new ExtrasFragment();
            case 4:
                return new DessertsFragment();
            case 5:
                return new SoftDrinksFragment();
            default:
                return new OfferFragment();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Offer";
            case 1:
                return "Family";
            case 2:
                return "Pizza";
            case 3:
                return "Extras";
            case 4:
                return "Desserts";
            case 5:
                return "Soft Drinks";
            default:
                return "Offer";
        }
    }
}
