package com.example.prm_project.activity.main;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.prm_project.R;
import com.example.prm_project.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        );
        setTheme(R.style.Theme_PRM_Project);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getColor(R.color.transparent));
        }
        setContentView(binding.getRoot());
        List<MainViewModel.Tab> tabs = viewModel.getTabs();
        MainAdapter adapter = new MainAdapter(tabs, this);
        binding.viewpager.setAdapter(adapter);
        new TabLayoutMediator(binding.navigation, binding.viewpager, (tab, position) -> {
            tab.setIcon(getResources().getDrawable(tabs.get(position).icon));
        }).attach();
        binding.viewpager.setUserInputEnabled(false);
        binding.navigation.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Integer position = tab.getPosition();
                if (position != null) {
                    binding.viewpager.setCurrentItem(position);
                    binding.navigation.selectTab(binding.navigation.getTabAt(position));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}