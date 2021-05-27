package com.superb.design.observe.observe1;

public class ObserveA extends Observe {

    public ObserveA(Subject subject) {
        this.subject = subject;
        this.subject.attch(this);
    }

    @Override
    public void update() {
        System.out.println("执行 更新A。。。");
    }
}
