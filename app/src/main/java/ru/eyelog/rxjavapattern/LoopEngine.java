package ru.eyelog.rxjavapattern;

import java.util.ArrayList;
import java.util.List;

public class LoopEngine {

    BlackSmith blackSmith;

    List<String> stringList;

    public LoopEngine() {
        blackSmith = new BlackSmith();
    }

    public List<String> getStringList(int steps, int length){
        stringList = new ArrayList<>();

        for (int i = 0; i < steps; i++) {
            stringList.add(blackSmith.getData(length));
        }

        return stringList;
    }
}
