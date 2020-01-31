package com.example.mohandesinarm.Model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ElanModel.class},version = 1)
public abstract class ElanDataBase extends RoomDatabase {
    public abstract ElanDao elanDao();


}
