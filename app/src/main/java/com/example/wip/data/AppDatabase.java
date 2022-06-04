package com.example.wip.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.wip.model.Thing;

@Database(entities = {Thing.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ClothesDao clothesDao();
}
