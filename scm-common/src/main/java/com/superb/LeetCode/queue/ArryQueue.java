package com.superb.LeetCode.queue;

/**
 * 数组实现队列
 * 对于数组，队尾tail指向的位置是空的，
 * 而链表的front（head一样）为头指针为空的，所以在不同结构实现相同效果的方法需要注意一下。
 */
public class ArryQueue<T> {
    private T data[];
    private int front;// 首位置
    private int rear;// 尾位置
    private int maxSize;// 最大长度

    /**
     * 构造一个初始长度为size的数组队列，尾指针需要一个数组位置，初始化数组大小是加1
     *
     * @param size
     */
    public ArryQueue(int size) {
        data = (T[]) new Object[size + 1];
        front = 0;
        rear = 0;
        maxSize = size + 1;
    }

    /**
     * 获取队列长度
     *
     * @return
     */
    public int length() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;

    }

    /**
     * 入队
     *
     * @param t
     * @throws Exception
     */
    public void push(T t) throws Exception {
        if (isFull()) {
            throw new Exception("已满");
        }
        data[rear] = t;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 出队
     *
     * @return
     * @throws Exception
     */
    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("已空");

        }

        T a = data[front];
        front = (front + 1) % maxSize;
        return a;
    }

    public String toString() {
        String va = "队头: ";
        int length = length();
        for (int i = 0; i < length; i++) {
            va += data[(front + i) % maxSize] + " ";
        }
        return va;
    }
}
