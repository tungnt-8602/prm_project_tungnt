package com.example.prm_project.fragment.home;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.prm_project.R;
import com.example.prm_project.activity.map.MapsActivity;
import com.example.prm_project.databinding.FragmentHomeBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements OnMapReadyCallback {
    FragmentHomeBinding binding;
    private MapView mapView;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        mapView = binding.mapViewHcm;
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initSlider();
        Log.d("ntt", "onClick: map");
        CardView map = binding.cardMap;
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ntt", "onClick: map click");
                Intent intent = new Intent(requireActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });
        String imageUrl = "https://mcdn.coolmate.me/uploads/April2022/Screen_Shot_2022-03-29_at_17.25_1.png";
        Picasso.get().load(imageUrl).into(binding.storyPic);
    }

    private void initSlider() {
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
        for (String imageItem : imageSlider) {
            sliderDataArrayList.add(new SliderData(imageItem));
        }
        SliderAdapter adapter = new SliderAdapter(sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng location = new LatLng(20.961153698330357, 105.7952372224912); // Ví dụ: Tọa độ TP.HCM
        googleMap.addMarker(new MarkerOptions().position(location).title("Coolmate.me in Hanoi"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15)); // Zoom vào vị trí cụ thể
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}