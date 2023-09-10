package com.example.prm_project.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.prm_project.R;
import com.example.prm_project.activity.login.LoginActivity;
import com.example.prm_project.databinding.FragmentSettingBinding;
public class SettingFragment extends Fragment{

    FragmentSettingBinding binding;

    public static String USER_FILE_NAME = "User";
    public static String NAME_KEY = "username";
    public static String PASS_KEY = "password";
    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSettingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences modePreferences = requireActivity().getSharedPreferences(USER_FILE_NAME, Context.MODE_PRIVATE);
        TextView username = binding.username;
        TextView email = binding.email;
        String usn = modePreferences.getString(NAME_KEY, "123");
        username.setText(usn);
        email.setText(usn + "@gmail.com");
        binding.logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modePreferences.edit().putString(NAME_KEY, null).apply();
                modePreferences.edit().putString(PASS_KEY, null).apply();
                Intent intent = new Intent(requireActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}