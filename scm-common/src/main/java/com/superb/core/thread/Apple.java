package com.superb.core.thread;


import com.alibaba.ttl.TransmittableThreadLocal;

public class Apple {

    public static InheritableThreadLocal<String> TL = new InheritableThreadLocal<>();
    public static TransmittableThreadLocal<String> TTL = new TransmittableThreadLocal<>();


    public Apple() {

    }

    public synchronized static void set(String value) {
        TL.set(value);
    }

    public synchronized static String get() {
        return TL.get();
    }

    public synchronized static void remove() {
        TL.remove();
    }

    public synchronized static void setTTL(String value) {
        TTL.set(value);
    }

    public synchronized static String getTTL() {
        return TTL.get();
    }

    public synchronized static void removeTTL() {
        TTL.remove();
    }
}
