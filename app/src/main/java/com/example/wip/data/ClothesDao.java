package com.example.wip.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wip.model.Thing;

import java.util.List;

@Dao
public interface ClothesDao {
    @Query("SELECT * FROM Thing")
    List<Thing> getAll();

    @Query("SELECT * FROM Thing")
    LiveData<List<Thing>> getAllLiveData();

    @Query("SELECT * FROM Thing WHERE uid IN (:userIds)")
    List<Thing> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Thing WHERE name = :name LIMIT 1")
    Thing findByName(String name);

    @Query("SELECT * FROM Thing WHERE uid = :uid LIMIT 1")
    Thing findById(int uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Thing clothes);

    @Update
    void update(Thing clothes);

    @Delete
    void delete(Thing clothes);
}
