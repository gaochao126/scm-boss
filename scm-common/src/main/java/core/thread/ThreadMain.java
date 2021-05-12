package core.thread;

import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;

public class ThreadMain {
    ExecutorService ex = ThreadUtil.newExecutor(10);
    ExecutorService executorService = TtlExecutors.getTtlExecutorService(ex);

    public static void main(String[] args) {
        ThreadMain t = new ThreadMain();
        t.c();
        t.d();
    }

    public void a() {
        executorService.submit(() -> {
            Apple.set("a");

            for (int i = 0; i < 100; i++) {
                new Thread(() -> {
//                    if (!TL.get().equalsIgnoreCase("b")) {
                    System.out.println("aaaaa子线程，子线程---------" + Thread.currentThread().getName() + ":" + Apple.get());
//                    }
                }).start();
            }

        });

    }

    public void b() {
        executorService.submit(() -> {
            Apple.set("b");

            for (int i = 0; i < 100; i++) {
                new Thread(() -> {
//                    if (!TL.get().equalsIgnoreCase("a")) {
                    System.out.println("bbbbb子线程，子线程---------" + Thread.currentThread().getName() + ":" + Apple.get());
//                    }
                }).start();
            }

        });
    }


    public void c() {
        executorService.submit(() -> {
            Apple.setTTL("c");

            for (int i = 0; i < 100; i++) {
                executorService.submit(() -> {
//                    if (!TL.get().equalsIgnoreCase("b")) {
                    System.out.println("cccc子线程，子线程---------" + Thread.currentThread().getName() + ":" + Apple.getTTL());
//                    }
                });
            }

        });

    }

    public void d() {
        executorService.submit(() -> {
            Apple.setTTL("d");

            for (int i = 0; i < 100; i++) {
                executorService.submit(() -> {
//                    if (!TL.get().equalsIgnoreCase("a")) {
                    System.out.println("ddddd子线程，子线程---------" + Thread.currentThread().getName() + ":" + Apple.getTTL());
//                    }
                });
            }

        });
    }
}
