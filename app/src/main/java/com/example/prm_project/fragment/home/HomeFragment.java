package com.example.prm_project.fragment.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prm_project.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    String url1 = "https://mcdn.coolmate.me/image/December2022/shop-ban-ao-thun-tron-tai-TPHCM-576_723.jpg";
    String url2 = "https://mcdn.coolmate.me/image/May2023/hot-goi-y-12-shop-do-tap-gym-nam-ha-noi-chat-luong-gia-tot-1691_250.jpg";
    String url3 = "https://cdn-www.vinid.net/be1bc24a-20200218_appvinid_bannerweb_coolmate-1.jpg";
    String url4 = "https://media.coolmate.me/cdn-cgi/image/quality=80,format=auto/uploads/April2023/summerMask_group.jpg";
    String url5 = "https://cafefcdn.com/203337114487263232/2021/5/3/shark-tank-4-tap-1-coolmate-7-16200045691081324100286.jpg";
    String url6 = "https://mcdn.coolmate.me/image/July2023/mceclip0_67.jpg";
    String url7 = "https://mcdn.coolmate.me/image/August2022/dac-tinh-ao-ba-lo.jpg";

    FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

//    public static HomeFragment newInstance(String param1, String param2) {
//        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = binding.imageSlider;

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));
        sliderDataArrayList.add(new SliderData(url4));
        sliderDataArrayList.add(new SliderData(url5));
        sliderDataArrayList.add(new SliderData(url6));
        sliderDataArrayList.add(new SliderData(url7));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(requireContext(), sliderDataArrayList);

        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }
}