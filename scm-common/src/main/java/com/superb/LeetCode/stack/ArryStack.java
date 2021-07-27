package com.superb.LeetCode.stack;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 数组实现栈：
 * 基于数组的栈——以数组为底层数据结构时，通常以数组头为栈底，数组头到数组尾为栈顶的生长方向
 *
 * @param <T>
 */
public class ArryStack<T> {

    private static int DEFAULT_SIZE = 10;
    private T data[];
    private int top;
    private int maxSize;


    public ArryStack() {
        this.data = (T[]) new Object[DEFAULT_SIZE];
        this.top = -1;
        this.maxSize = DEFAULT_SIZE;
    }

    /**
     * 初始化一个栈
     *
     * @param maxSize
     */
    public ArryStack(int maxSize) {
        this.data = (T[]) new Object[maxSize];
        this.top = -1;
        this.maxSize = maxSize;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 栈是否已满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 返回栈深度
     *
     * @return
     */
    public int length() {
        return top;
    }

    /**
     * 入栈
     *
     * @param t
     * @throws Exception
     */
    public void push(T t) throws Exception {
        if (isFull()) {
            throw new Exception("栈满");
        }
        top = top + 1;
        data[top] = t;
    }

    /**
     * 出栈
     *
     * @throws Exception
     */
    public void pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("栈空");
        }
        data[top] = null;
        top = top - 1;
    }

    public void clen() {
        data = (T[]) new Object[maxSize];
        top = -1;
    }

    public String toString() {
        String v = "";
        if (!isEmpty()) {
            for (int i = 0; i < data.length; i++) {
                if (!Objects.isNull(data[i])) {
                    v = v + data[i] + "  ";
                }
            }
        }

        return v;
    }
}
