package com.example.prm_project.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.prm_project.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initSlider();
    }

    private void initSlider(){
        ArrayList<String> imageSlider = new ArrayList<>();
        imageSlider.add("https://mcdn.coolmate.me/image/December2022/shop-ban-ao-thun-tron-tai-TPHCM-576_723.jpg");
        imageSlider.add("https://mcdn.coolmate.me/image/May2023/hot-goi-y-12-shop-do-tap-gym-nam-ha-noi-chat-luong-gia-tot-1691_250.jpg");
        imageSlider.add("https://cdn-www.vinid.net/be1bc24a-20200218_appvinid_bannerweb_coolmate-1.jpg");
        imageSlider.add("https://media.coolmate.me/cdn-cgi/image/quality=80,format=auto/uploads/April2023/summerMask_group.jpg");
        imageSlider.add("https://cafefcdn.com/203337114487263232/2021/5/3/shark-tank-4-tap-1-coolmate-7-16200045691081324100286.jpg");
        imageSlider.add("https://mcdn.coolmate.me/image/July2023/mceclip0_67.jpg");
        imageSlider.add("https://mcdn.coolmate.me/image/August2022/dac-tinh-ao-ba-lo.jpg");
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        SliderView sliderView = binding.imageSlider;
        for (String imageItem: imageSlider) {
            sliderDataArrayList.add(new SliderData(imageItem));
        }
        SliderAdapter adapter = new SliderAdapter(sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }
}