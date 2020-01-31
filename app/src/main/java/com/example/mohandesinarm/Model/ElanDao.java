package com.example.mohandesinarm.Model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ElanDao {
    @Query("SELECT * FROM ElanModel")
    List<ElanModel> getAll();
    @Insert
        //... yani chand ta vared konim
    void insertAll(ElanModel... elanModel);
    @Delete
    void delete(ElanModel... elanModel);
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    public void insertElans(ElanModel... elanModels);
//    @Insert
//    public void insertBothElans(ElanModel elanModel, ElanModel elanMode2);

}
