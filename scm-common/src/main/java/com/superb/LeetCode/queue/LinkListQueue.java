package com.superb.LeetCode.queue;

/**
 * 链表实现队列
 *
 * @param <T>
 */
public class LinkListQueue<T> {

    static class Node<T> {
        T data;
        Node next;

        public Node() {
        }

        public Node(T t) {
            data = t;
        }
    }

    Node front;// 首节点
    Node rear;// 尾节点

    /**
     * 初始化一个队列，首节点为null
     */
    public LinkListQueue() {
        front = new Node();
        rear = front;
    }

    /**
     * 获取队列长度
     *
     * @return
     */
    public int length() {
        int len = 0;
        Node node = front;
        while (node != rear) {
            len++;
            node = node.next;
        }
        return len;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加队列
     *
     * @param t
     */
    public void push(T t) {
        Node<T> tNode = new Node<>(t);
        rear.next = tNode;
        rear = tNode;
    }

    /**
     * 删除队列
     */
    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("已空");
        }

        T node = (T) front.next.data;
        front.next = front.next.next;

        return node;
    }

    /**
     * toString 队列
     *
     * @return
     */
    public String toString() {
        Node node = front.next;

        String va = "队列头：";
        while (node != null) {
            va = va + node.data;
            node = node.next;
        }
        return va;
    }
}
