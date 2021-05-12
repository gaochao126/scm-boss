package com.superb.lock;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {

    public static void main(String[] args) throws Exception{

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("这是两个线程都执行完，执行的代码。。。。");
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1执行。。");
                try {
                    cyclicBarrier.await();
                }catch (Exception e){

                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2执行。。");
                try {
                    cyclicBarrier.await();
                }catch (Exception e){

                }
            }
        });
        t2.start();

    }
}
