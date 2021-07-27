package com.superb.LeetCode.stack;

import java.util.Objects;

public class LinkedStack<T> {

    private Node<T> top = null;

    public LinkedStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return Objects.isNull(top);
    }

    public void push(T t) {
        Node<T> node = new Node<>(t);
        node.setNext(top);
        top = node;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T t = top.data;
        top = top.getNext();
        return t;
    }

    /**
     * 返回栈深
     *
     * @return
     */
    public int length() {
        int len = -1;
        if (isEmpty()) {
            return len;
        }

        while (top.getNext() != null) {
            len = len + 1;
            top = top.getNext();
        }

        return len + 1;
    }

    public String toString() {
        String s = "";
        if (isEmpty()) {
            return "";
        }

        while (top.getNext() != null) {
            s = s + top.getData();
            top = top.getNext();
        }
//        sb.append(top.getData());
        return s;
    }

    static class Node<T> {
        private T data;
        private Node<T> next;


        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
