package com.example.wip.screens.details;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wip.App;
import com.example.wip.R;
import com.example.wip.model.Thing;

public class ThingDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_THING = "ThingDetails.EXTRA_THING";

    private Thing thing;

    private EditText editText;

    public static void start(Activity caller, Thing thing) {
        Intent intent = new Intent(caller, ThingDetailsActivity.class);
        if (thing != null) {
            intent.putExtra(EXTRA_THING, thing);
        }
        caller.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_thing_details);

        editText = findViewById(R.id.thing_name);

        if (getIntent().hasExtra(EXTRA_THING)) {
            thing = getIntent().getParcelableExtra(EXTRA_THING);
            editText.setText(thing.name);
        } else {
            thing = new Thing();
        }
    }

    public void save(View view) {
        if (editText.getText().length() > 0){
            thing.name = editText.getText().toString();

            //Добавление или обновление карточки
            if (getIntent().hasExtra(EXTRA_THING)) {
                App.getInstance().getClothesDao().update(thing);
            } else {
                App.getInstance().getClothesDao().insert(thing);
            }
            finish();
        }

    }

    public void close(View view){
        this.finish();
    }
}