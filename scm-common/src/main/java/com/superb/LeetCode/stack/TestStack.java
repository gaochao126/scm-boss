package com.superb.LeetCode.stack;

public class TestStack {

    public static void main(String[] args) throws Exception {
//        testArrayStack();
        testLinkedStack();
    }

    public static void testArrayStack() throws Exception {
        ArryStack<String> arryStack = new ArryStack<>(5);

        System.out.println("isEmpty：" + arryStack.isEmpty());
        System.out.println("length：" + arryStack.length());
        arryStack.push("哈哈1");
        arryStack.push("哈哈2");
        arryStack.push("哈哈3");
        arryStack.pop();
        arryStack.push("哈哈4");
        System.out.println("isEmpty：" + arryStack.isEmpty());
        System.out.println("length：" + arryStack.length());
        System.out.println(arryStack.toString());

    }

    public static void testLinkedStack() {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        System.out.println("isEmpty：" + linkedStack.isEmpty());
        System.out.println("length：" + linkedStack.length());

        linkedStack.push("栈1");
        linkedStack.push("栈2");
        linkedStack.push("栈3");
        linkedStack.push("栈4");
        System.out.println("1："+linkedStack.pop());
        System.out.println("1："+linkedStack.pop());
        System.out.println("1："+linkedStack.pop());
        System.out.println("1："+linkedStack.pop());

    }
}
