package com.superb.core.thread.callback;

public interface ParallelTask<T> {

    String getTaskKey();
    T execute();

}
