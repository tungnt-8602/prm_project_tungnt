package com.example.prm_project.activity.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.prm_project.ProductDetailFragment;
import com.example.prm_project.fragment.FavoriteFragment;
import com.example.prm_project.fragment.home.HomeFragment;
import com.example.prm_project.fragment.ProductFragment;
import com.example.prm_project.fragment.SettingFragment;

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
                    fragment = new FavoriteFragment();
                    break;
                case SETTING:
                    fragment = new SettingFragment();
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
