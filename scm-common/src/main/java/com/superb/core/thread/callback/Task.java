package com.superb.core.thread.callback;

import lombok.Data;

public class Task implements ParallelTask<CallBackResult> {

    private Order order;

    public Task(Order order) {
        this.order = order;
    }

    @Override
    public String getTaskKey() {
        return this.order.getKey();
    }

    @Override
    public CallBackResult execute() {
        try {
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new CallBackResult(order.getKey(), order.getType());
    }
}
