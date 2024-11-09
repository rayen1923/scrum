package IDAO;

import android.content.Context;

public interface IUserDao {
     void loginUser(Context context, String username, String password);
     void registerUser(Context context, String firstName, String lastName, String email, String password, int phone);
}
