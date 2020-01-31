package com.example.mohandesinarm.Model;

import android.content.Context;

import androidx.room.Room;

public class Client {
    private  static ElanDataBase elanDataBase =null;
    public static ElanDataBase getClient(Context context){
        if (elanDataBase == null){
            elanDataBase = Room.databaseBuilder(context,ElanDataBase.class,"Elandatabase").build();
        }
        return elanDataBase;
    }
}
