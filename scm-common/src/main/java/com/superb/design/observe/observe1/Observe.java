package com.superb.design.observe.observe1;

/**
 * 观察者抽象类
 */
public abstract class Observe {

    protected Subject subject;

    public abstract void update();
}
