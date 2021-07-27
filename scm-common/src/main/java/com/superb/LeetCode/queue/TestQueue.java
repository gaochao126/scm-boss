package com.superb.LeetCode.queue;

/**
 * 数组、链表分别实现队列
 * // https://www.cnblogs.com/bigsai/p/11363071.html
 */
public class TestQueue {
    public static void main(String[] args) throws Exception {
//        testArryQueue();

        testLinkListQueue();
    }


    /**
     * 测试数组实现的队列
     *
     * @throws Exception
     */
    public static void testArryQueue() throws Exception {
        ArryQueue<String> arryQueue = new ArryQueue<>(5);

        System.out.println("isEmpty：" + arryQueue.isEmpty());
        System.out.println("isFull：" + arryQueue.isFull());
        System.out.println("length：" + arryQueue.length());
        arryQueue.push("哈哈1");
        arryQueue.push("哈哈2");
        arryQueue.push("哈哈3");
        arryQueue.push("哈哈4");
        arryQueue.push("哈哈5");
//        arryQueue.push("哈哈6");
        System.out.println("isEmpty：" + arryQueue.isEmpty());
        System.out.println("isFull：" + arryQueue.isFull());
        System.out.println("length：" + arryQueue.length());

        System.out.println(arryQueue.toString());

    }

    /**
     * 链表实现队列
     */
    public static void testLinkListQueue() {
        LinkListQueue<String> linkListQueue = new LinkListQueue<>();

        System.out.println("isEmpty：" + linkListQueue.isEmpty());
        System.out.println("length：" + linkListQueue.length());
        linkListQueue.push("哈哈1 ");
        linkListQueue.push("哈哈2 ");
        linkListQueue.push("哈哈3 ");
        System.out.println("isEmpty：" + linkListQueue.isEmpty());
        System.out.println("length：" + linkListQueue.length());
        System.out.println(linkListQueue.toString());
    }

}
