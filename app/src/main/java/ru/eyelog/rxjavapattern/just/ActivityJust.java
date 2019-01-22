package ru.eyelog.rxjavapattern.just;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import io.reactivex.Observable;
import ru.eyelog.rxjavapattern.R;

public class ActivityJust extends AppCompatActivity {

    TextView textView;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just);

        textView = findViewById(R.id.textView);

        Observable.just("Do the text")
                .subscribe(s -> textView.setText(s));
    }
}
