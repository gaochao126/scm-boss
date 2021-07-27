package com.superb.itfc;

import org.springframework.beans.factory.annotation.Autowired;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.a();
    }

    /**
     * 接口作为方法参数，解构
     */

    @Autowired
    InterfaceTwo interfaceTwo;

    public void a() {
        InterfaceTemplate.handel("a", "b", "c", interfaceTwo::push);
    }
}
