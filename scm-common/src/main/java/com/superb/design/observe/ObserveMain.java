package com.superb.design.observe;

import com.superb.design.observe.observe1.ObserveA;
import com.superb.design.observe.observe1.ObserveB;
import com.superb.design.observe.observe1.Subject;

public class ObserveMain {

    public static void main(String[] args) {
        Subject subject = new Subject();
        new ObserveA(subject);
        new ObserveB(subject);

        subject.setState(15);
    }
}
