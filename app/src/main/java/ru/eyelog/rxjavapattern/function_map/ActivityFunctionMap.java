package ru.eyelog.rxjavapattern.function_map;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import ru.eyelog.rxjavapattern.R;

public class ActivityFunctionMap extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_map);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTest);
        button = findViewById(R.id.button);

        Function<Integer, Integer> doubleSomething = value -> value * 2;

        button.setOnClickListener(v -> {
            int val = Integer.parseInt(editText.getText().toString());

            Observable<Integer> observable = Observable
                    .just(val)
                    .map(doubleSomething);

            Observer<Integer> observer = new Observer<Integer>() {
                @Override
                public void onSubscribe(Disposable d) {
                }

                @Override
                public void onNext(Integer integer) {
                    textView.setText(String.valueOf(integer));
                }

                @Override
                public void onError(Throwable e) {
                }

                @Override
                public void onComplete() {
                }
            };

            observable.subscribe(observer);
        });
    }
}
