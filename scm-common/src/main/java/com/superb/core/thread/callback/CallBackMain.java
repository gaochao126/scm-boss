package com.superb.core.thread.callback;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CallBackMain {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(start);
        Order order1 = new Order();
        order1.setKey("1");
        order1.setType("one");

        Order order2 = new Order();
        order2.setKey("2");
        order2.setType("two");

        Order order3 = new Order();
        order3.setKey("3");
        order3.setType("three");


        Task task1 = new Task(order1);
        Task task2 = new Task(order2);
        Task task3 = new Task(order3);
        List<ParallelTask> list = new ArrayList<>();
        list.add(task1);
        list.add(task2);
        list.add(task3);

        Map<String, Object> execute = ParallelTaskExecutor.execute(list);

        System.out.println(JSON.toJSON(execute));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }
}
