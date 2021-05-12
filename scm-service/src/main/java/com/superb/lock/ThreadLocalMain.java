package com.superb.lock;

public class ThreadLocalMain {

    private static ThreadLocal<String> tl = new ThreadLocal<>();
    public static void main(String[] args) {
        tl.set("哈哈");
    }
}
