package com.superb.itfc.impl;

        import com.superb.itfc.InterfaceTwo;

public class InterfaceTwoImpl implements InterfaceTwo {
    @Override
    public void push(String a, String b, String c) {
        System.out.println("a：" + a + ";" + b + ";" + c);
    }
}
