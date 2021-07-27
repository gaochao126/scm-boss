package com.superb.LeetCode.tree;


import java.util.Deque;
import java.util.LinkedList;

public class TestTree {

    public static void main(String[] args) {
        TreeNode<User> node = new TreeNode<>();


        TreeNode<User> tr = new TreeNode<>();
        User r = new User();
        r.setAge(11);
        r.setId(11);
        tr.setData(r);


        TreeNode<User> lr = new TreeNode<>();
        User u = new User();
        r.setAge(21);
        r.setId(21);
        lr.setData(r);

        node.setIndex(1);
        node.setData(u);
        node.setLeft(lr);
        node.setRight(tr);

        int c = maxDepth(node);
        System.out.println(c);

    }

    public static int maxDepth(TreeNode<User> root) {
        if (root == null)
            return 0;
        //创建一个队列
        Deque<TreeNode<User>> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()) {
            //每一层的个数
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pop();
                if (cur.getLeft() != null)
                    deque.addLast(cur.getLeft());
                if (cur.getRight() != null)
                    deque.addLast(cur.getRight());
            }
            count++;
        }
        return count;
    }

}
