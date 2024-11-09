package com.example.ikrili;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView userIdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Intent intent = getIntent();
        int userId = intent.getIntExtra("id", -1);*/

        /*userIdTextView = findViewById(R.id.user_id_text_view);
        userIdTextView.setText("User ID: " + userId);*/
    }
}
