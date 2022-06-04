package com.example.wip.screens.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.wip.App;
import com.example.wip.model.Thing;

import java.util.List;

public class MainViewModel extends ViewModel {
    private LiveData<List<Thing>> nateLiveData = App.getInstance().getClothesDao().getAllLiveData();

    public LiveData<List<Thing>> getNateLiveData() {
        return nateLiveData;
    }
}
