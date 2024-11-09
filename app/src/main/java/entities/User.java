package entities;

public class User {
    private int User_id;
    private String Name;
    private String Mail;
    private int Phone;
    private String Password;

    public User() {
    }

    public User (int id,String name,String mail,int phone,String password){
        User_id = id;
        Name = name;
        Mail = mail;
        Phone = phone;
        Password = password;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }
}
