package com.example.prm_project.activity.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prm_project.R;
import com.example.prm_project.activity.main.MainActivity;
import com.example.prm_project.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    public static String USER_FILE_NAME = "User";
    public static String NAME_KEY = "username";
    public static String PASS_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_PRM_Project);
        SharedPreferences modePreferences = getSharedPreferences(USER_FILE_NAME, Context.MODE_PRIVATE);
        String saveUsername = modePreferences.getString(NAME_KEY, "000");
        String savePassword = modePreferences.getString(PASS_KEY, "000");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getColor(R.color.transparent));
        }
        if (!saveUsername.equals("000") && !savePassword.equals("000")) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        } else {
            binding = ActivityLoginBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            EditText userNameEdt = binding.idEdtUserName;
            EditText passwordEdt = binding.idEdtPassword;

            binding.idBtnLogin.setOnClickListener(v -> {
                String userName = userNameEdt.getText().toString();
                String password = passwordEdt.getText().toString();

                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(userName, password);
                }
                loginUser(userName, password);
            });
        }
    }

    private void loginUser(String userName1, String password1) {
        SharedPreferences modePreferences = getSharedPreferences(USER_FILE_NAME, Context.MODE_PRIVATE);
        String saveUsername = modePreferences.getString(NAME_KEY, "123");
        String savePassword = modePreferences.getString(PASS_KEY, "123");
        if (userName1 != null && password1 != null && userName1.equals(saveUsername) && password1.equals(savePassword)) {

            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            i.putExtra("username", userName1);
            modePreferences.edit().putString(NAME_KEY, userName1).apply();
            modePreferences.edit().putString(PASS_KEY, password1).apply();
            startActivity(i);
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "làm lại đi", Toast.LENGTH_LONG).show();
        }
    }
}