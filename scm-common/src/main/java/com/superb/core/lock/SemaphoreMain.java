package com.superb.core.lock;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreMain {

    private static Semaphore semaphore = new Semaphore(50);

    /**
     * 模拟50辆车，停车
     *
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("====" + Thread.currentThread().getName() + "来到停车场");

                        if (semaphore.availablePermits() == 0) {
                            System.out.println("可用停车位为：0");
                        }

                        semaphore.acquire();

                        System.out.println(Thread.currentThread().getName() + "成功进入停车场");
                        Thread.sleep(new Random().nextInt(10000));//模拟车辆在停车场停留的时间
                        System.out.println(Thread.currentThread().getName() + "驶出停车场");

                        semaphore.release();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, i + "车号");
            thread.start();
        }
    }
}
