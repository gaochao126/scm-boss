package com.superb.design.observe.observe1;

public class ObserveB extends Observe {

    public ObserveB(Subject subject) {
        this.subject = subject;
        this.subject.attch(this);
    }

    @Override
    public void update() {
        System.out.println("执行更新b....");
    }
}
