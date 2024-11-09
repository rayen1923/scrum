package com.example.ikrili;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import DAO.UserDao;
import IDAO.IUserDao;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private TextView registerNowTextView;
    private IUserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.Txtm);
        passwordEditText = findViewById(R.id.Txtp);
        loginButton = findViewById(R.id.Btnr);
        registerNowTextView = findViewById(R.id.register_now);
        userDao = new UserDao();

        loginButton.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            userDao.loginUser(LoginActivity.this, username, password);
        });

        registerNowTextView.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        });
    }
}
