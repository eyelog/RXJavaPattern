package ru.eyelog.rxjavapattern.array_from;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ru.eyelog.rxjavapattern.R;

public class ActivityArrayFrom extends AppCompatActivity {

    TextView textView;
    Button buttonFromArray, buttonFrom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array_arrayfrom);

        textView = findViewById(R.id.textView);
        buttonFromArray = findViewById(R.id.buttonFromArray);
        buttonFrom = findViewById(R.id.buttonFrom);

        String[] stArray = new String[]{"One", "Two", "Three"};

        Observable<String> observableFromArray = Observable.fromArray(stArray);

        buttonFromArray.setOnClickListener(v -> {
            Observer<String> observerFromArray = new Observer<String>() {
                @Override
                public void onSubscribe(Disposable d) {
                    Log.i("Logcat:", "onSubscribe:" + d.toString());
                }

                @Override
                public void onNext(String s) {
                    Log.i("Logcat:", "onNext: " + s);
                }

                @Override
                public void onError(Throwable e) {
                    Log.i("Logcat:", "onError: " + e);
                }

                @Override
                public void onComplete() {
                    Log.i("Logcat:", "onComplete");
                }
            };

            observableFromArray.subscribe(observerFromArray);

        });

        buttonFrom.setOnClickListener(v -> {

        });
    }
}
