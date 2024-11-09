package DAO;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.ikrili.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import IDAO.IUserDao;
import entities.User;

public class UserDao implements IUserDao {

    public void loginUser(Context context, String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Both fields are required!", Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("users");

        usersRef.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    User user = dataSnapshot.getValue(User.class);
                    if (user != null && user.getPassword().equals(password)) {
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.putExtra("id", user.getUser_id());
                        context.startActivity(intent);
                    } else {
                        Toast.makeText(context, "Incorrect password!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "User not found!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(context, "Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void registerUser(Context context, String firstName, String lastName, String email, String password, int phone) {
        if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(context, "All fields are required!", Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("users");
        DatabaseReference lastUserIdRef = database.getReference("lastUserId");

        lastUserIdRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int newUserId;

                if (dataSnapshot.exists()) {
                    Integer lastUserId = dataSnapshot.getValue(Integer.class);
                    newUserId = (lastUserId != null) ? lastUserId + 1 : 1;
                } else {
                    newUserId = 1;
                }

                User user = new User(newUserId, firstName + " " + lastName, email, phone, password);

                usersRef.child(firstName + " " + lastName).setValue(user)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                lastUserIdRef.setValue(newUserId);

                                Intent intent = new Intent(context, MainActivity.class);
                                intent.putExtra("id", user.getUser_id());
                                context.startActivity(intent);
                            } else {
                                Toast.makeText(context, "Registration failed: " + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(context, "Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
