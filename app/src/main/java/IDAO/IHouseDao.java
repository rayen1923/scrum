package IDAO;

import android.content.Context;

import entities.House;

public interface IHouseDao {
    void saveHouse(Context context, House house);
}
