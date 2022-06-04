package com.example.wip.screens.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.wip.ClothesFragment;
import com.example.wip.JourneyFragment;
import com.example.wip.MainFragment;
import com.example.wip.R;
import com.example.wip.SetFragment;
import com.example.wip.screens.details.ThingDetailsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(MainFragment.newInstance());
        //Navigation View
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    //Метод создания и редактирование диологового окна
    private void dialog_chouse()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.chouse,null);
        builder.setView(cl);
        builder.show();
    }
    //Переход на активити создания новой вещи
    public void add_clothes(View view) {
        Intent intent = new Intent(this, ThingDetailsActivity.class);
        startActivity(intent);
    }

    public void plus(View view) {
        dialog_chouse();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        //Переключение фрагментов
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mihome: //Фрагмент главного экрана
                    loadFragment(MainFragment.newInstance());
                    return true;
                case R.id.miclothes: //Фрагмент вещей
                    loadFragment(ClothesFragment.newInstance());
                    return true;
                case R.id.miset: //Фрагмент комплектов
                    loadFragment(SetFragment.newInstance());
                    return true;
                case R.id.mijourney: //фрагмент путешествий
                    loadFragment(JourneyFragment.newInstance());
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }

}