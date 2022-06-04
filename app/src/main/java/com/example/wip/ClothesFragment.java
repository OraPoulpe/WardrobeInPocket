package com.example.wip;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wip.model.Thing;
import com.example.wip.screens.main.Adapter;
import com.example.wip.screens.main.MainViewModel;

import java.util.List;

import io.reactivex.Observer;

public class ClothesFragment extends Fragment {

    private RecyclerView recyclerView;

    public ClothesFragment() {
    }

    public static ClothesFragment newInstance() {
        return new ClothesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_clothes, container, false);

        /*recyclerView = recyclerView.findViewById();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        final Adapter adapter = new Adapter();
        recyclerView.setAdapter(adapter);


        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getNoteLiveData().observe(this, new Observer<List<Thing>>() {
            @Override
            public void onChanged(List<Thing> notes) {
                adapter.setItems(notes);
            }
    }*/
    }
}