package entities;

public class Student extends User {
    private String Uni;
    public Student(int id, String name, String mail, int phone, String password,String uni) {
        super(id, name, mail, phone, password);
        Uni = uni;
    }

    public String getUni() {
        return Uni;
    }

    public void setUni(String uni) {
        Uni = uni;
    }
}
