package ru.eyelog.rxjavapattern;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import ru.eyelog.rxjavapattern.arrange.ActivityArrange;
import ru.eyelog.rxjavapattern.array_from.ActivityArrayFrom;
import ru.eyelog.rxjavapattern.function_map.ActivityFunctionMap;
import ru.eyelog.rxjavapattern.just.ActivityJust;

public class MainActivity extends AppCompatActivity {

    Button btArrange, btJust, btArray, btFuncMap;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btArrange = findViewById(R.id.btArrange);
        btJust = findViewById(R.id.btJust);
        btArray = findViewById(R.id.btArray);
        btFuncMap = findViewById(R.id.btFuncMap);

        btArrange.setOnClickListener(v -> {
            intent = new Intent(this, ActivityArrange.class);
            startActivity(intent);
        });

        btJust.setOnClickListener(v -> {
            intent = new Intent(this, ActivityJust.class);
            startActivity(intent);
        });

        btArray.setOnClickListener(v -> {
            intent = new Intent(this, ActivityArrayFrom.class);
            startActivity(intent);
        });

        btFuncMap.setOnClickListener(v -> {
            intent = new Intent(this, ActivityFunctionMap.class);
            startActivity(intent);
        });


    }
}
