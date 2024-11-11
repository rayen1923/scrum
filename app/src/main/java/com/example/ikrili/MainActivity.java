package com.example.ikrili;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("UserSession", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        String username = sharedPreferences.getString("username", "");
        int userId = sharedPreferences.getInt("id", -1);
        Toast.makeText(MainActivity.this, "User ID: " + userId, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, Profile.class));


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_profile) {
                startActivity(new Intent(MainActivity.this, Profile.class));
                return true;
            } else if (id == R.id.nav_search) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                return true;
            } else if (id == R.id.nav_add) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
                return true;
            } else if (id == R.id.nav_message) {
                startActivity(new Intent(MainActivity.this, MessageActivity.class));
                return true;
            } else if (id == R.id.nav_notification) {
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                return true;
            }
            return false;
        });
    }
}
