package ru.eyelog.rxjavapattern.arrange;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class ReactEngine {

    BlackSmith blackSmith;

    List<String> stringList;

    List<Integer> ram;

    public ReactEngine() {
        blackSmith = new BlackSmith();
    }

    public List<String> getStringList(int steps, int length){
        stringList = new ArrayList<>();

        Observable<Integer> observable = Observable.range(1, steps);

        Observer<Integer> observer = new Observer<Integer>(){

            @Override
            public void onSubscribe(@NonNull Disposable d) {
            }

            @Override
            public void onNext(@NonNull Integer s) {
                stringList.add(blackSmith.getData(s * length));
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };

        observable.subscribe(observer);

        return stringList;
    }
}
