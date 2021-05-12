package com.superb.lock;

public class ReentrantLockMain {

    public static void main(String[] args) throws Exception {
        ReenTrantLockTest t = new ReenTrantLockTest();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("当前请求：" + i);

            t.currentUntimed();
        }

    }
}
