package com.example.ikrili;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import DAO.UserDao;
import IDAO.IUserDao;

public class SignUpActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText, phoneEditText;
    private Button registerButton;
    private IUserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstNameEditText = findViewById(R.id.Txtfn);
        lastNameEditText = findViewById(R.id.Txtln);
        emailEditText = findViewById(R.id.Txtm);
        passwordEditText = findViewById(R.id.Txtp);
        phoneEditText = findViewById(R.id.Txtt);
        registerButton = findViewById(R.id.Btnr);

        registerButton.setOnClickListener(view -> {
            String firstName = firstNameEditText.getText().toString().trim();
            String lastName = lastNameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String phoneStr = phoneEditText.getText().toString().trim();

            try {
                int phone = Integer.parseInt(phoneStr);
                userDao = new UserDao();

                userDao.registerUser(this, firstName, lastName, email, password, phone);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
