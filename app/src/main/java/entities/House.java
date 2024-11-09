package entities;

import java.util.ArrayList;

public class House {
    private int House_id;
    private String Adress;
    private String Description;
    private ArrayList<String> Images;
    private int Nb_place;
    private int Nb_place_oc;
    private float Place_prix;
    private int Owner_id;
    private ArrayList<Integer> Students;

    public House(int id, String adress, String des, ArrayList<String> images, int nbp, int nbpo, float prix, int owner_id) {
        House_id = id;
        Adress = adress;
        Description = des;
        Images = images;
        Nb_place = nbp;
        Nb_place_oc = nbpo;
        Place_prix = prix;
        Owner_id = owner_id;
        Students = new ArrayList<Integer>();
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public float getPlace_prix() {
        return Place_prix;
    }

    public void setPlace_prix(float place_prix) {
        Place_prix = place_prix;
    }

    public int getNb_place_oc() {
        return Nb_place_oc;
    }

    public void setNb_place_oc(int nb_place_oc) {
        Nb_place_oc = nb_place_oc;
    }

    public int getNb_place() {
        return Nb_place;
    }

    public void setNb_place(int nb_place) {
        Nb_place = nb_place;
    }

    public ArrayList<String> getImages() {
        return Images;
    }

    public void setImages(ArrayList<String> images) {
        Images = images;
    }

    public int getHouse_id() {
        return House_id;
    }

    public void setHouse_id(int house_id) {
        House_id = house_id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getOwner_id() {
        return Owner_id;
    }

    public void setOwner_id(int owner_id) {
        Owner_id = owner_id;
    }

    public ArrayList<Integer> getStudents() {
        return Students;
    }

    public void setStudents(ArrayList<Integer> students) {
        Students = students;
    }
}

