package com.example.ikrili;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import DAO.HouseDao;
import IDAO.IHouseDao;
import entities.House;

public class AddActivity extends AppCompatActivity {
    private EditText etAddress, etDescription, etNbPlace, etNbPlaceOc, etPrice, etOwnerId;
    private IHouseDao houseDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etAddress = findViewById(R.id.etAddress);
        etDescription = findViewById(R.id.etDescription);
        etNbPlace = findViewById(R.id.etNbPlace);
        etPrice = findViewById(R.id.etPrice);

        houseDao = new HouseDao();
        findViewById(R.id.btnSaveHouse).setOnClickListener(v -> {
            String address = etAddress.getText().toString().trim();
            String description = etDescription.getText().toString().trim();
            String nbPlace = etNbPlace.getText().toString().trim();
            String price = etPrice.getText().toString().trim();

            SharedPreferences sharedPreferences = getSharedPreferences("UserSession", MODE_PRIVATE);
            int userId = sharedPreferences.getInt("id", -1);

            if (!address.isEmpty() && !description.isEmpty() && !nbPlace.isEmpty() && !price.isEmpty() && userId != -1) {
                House house = new House(0, address, description, Integer.parseInt(nbPlace), Integer.parseInt(price), userId);
                houseDao.saveHouse(AddActivity.this, house);
            } else {
                Toast.makeText(AddActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_add);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_profile) {
                startActivity(new Intent(AddActivity.this, Profile.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            } else if (id == R.id.nav_search) {
                startActivity(new Intent(AddActivity.this, SearchActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            } else if (id == R.id.nav_add) {
                startActivity(new Intent(AddActivity.this, AddActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            } else if (id == R.id.nav_message) {
                startActivity(new Intent(AddActivity.this, MessageActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            } else if (id == R.id.nav_notification) {
                startActivity(new Intent(AddActivity.this, NotificationActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            }
            return false;
        });
    }

}