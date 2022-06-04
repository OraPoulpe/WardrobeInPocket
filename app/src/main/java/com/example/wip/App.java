package com.example.wip;

import android.app.Application;

import androidx.room.Room;

import com.example.wip.data.AppDatabase;
import com.example.wip.data.ClothesDao;

public class App extends Application {

    private AppDatabase database;
    private ClothesDao clothesDao;

    private static App instance;

    public static App getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-db-name")
                .allowMainThreadQueries()
                .build();

        clothesDao = database.clothesDao();

    }

    public AppDatabase getDatabase() {
        return database;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    public ClothesDao getClothesDao() {
        return clothesDao;
    }

    public void setClothesDao(ClothesDao clothesDao) {
        this.clothesDao = clothesDao;
    }
}
