package com.superb.design.observe.observe1;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observe> observeList = new ArrayList<>();

    private int state;


    public void attch(Observe observe) {
        observeList.add(observe);
    }

    public void notifyAllObserver() {
        for (Observe o : observeList) {
            o.update();
        }
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }
}
