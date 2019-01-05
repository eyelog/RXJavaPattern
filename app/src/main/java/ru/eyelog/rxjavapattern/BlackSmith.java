package ru.eyelog.rxjavapattern;

public class BlackSmith {

    public BlackSmith() {
    }

    public String getData(int i){
        String out = "";
        int a = 1;

        for (int j = 0; j < i; j++) {
            out += a + ", ";
            a = a + a*j;
        }
        out += a;

        return out;
    }
}
