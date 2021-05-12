package com.superb.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchMain {

    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(10);

        for (int i=0; i<5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 运行");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            }).start();

        }

        System.out.println("等待子线程运行结束");
        latch.await();
        System.out.println("子线程运行结束");
    }
}
