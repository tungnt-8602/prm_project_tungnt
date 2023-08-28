package com.example.prm_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.prm_project.fragment.HomeFragment;
import com.example.prm_project.fragment.ProductFragment;

import java.util.List;

public class MainAdapter extends FragmentStateAdapter {

    private final List<MainViewModel.Tab> tabs;

    public MainAdapter(List<MainViewModel.Tab> tabs, AppCompatActivity activity) {
        super(activity);
        this.tabs = tabs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        MainViewModel.Tab item = tabs.get(position);
        Fragment fragment = item.fragment;
        if (fragment == null) {
            switch (item.type) {
                case HOME:
                    fragment = new HomeFragment();
                    break;
                case PRODUCT:
                    fragment = new ProductFragment();
                    break;
                case FAVORITE:
                    fragment = new HomeFragment();
                    break;
                case SETTING:
                    fragment = new ProductFragment();
                    break;
            }
            tabs.get(position).fragment = fragment;
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return tabs.size();
    }
}
