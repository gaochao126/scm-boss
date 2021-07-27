package com.superb.LeetCode.arry;

public class TestArry {

    public static void main(String[] args) {
//        deleteRepeatEle();
//        maxProfit();
//        rotate(1);
        a();
    }

    /**
     * 要求：
     * <p>
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
     * 返回删除后数组的新长度。
     * </p>
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * </p>
     */
    public static int deleteRepeatEle() {
        int[] nums = {1, 1, 2};
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;

    }


    /**
     * 买卖股票的最佳时机
     * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * @return
     */
    public static int maxProfit() {
        int[] prices = {1, 3, 5, 6, 3, 2, 2, 5, 6, 7};
        int max = 0;
        if (prices.length > 1) {
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    max = max + prices[i + 1] - prices[i];
                }
            }

        }
        System.out.println("最大收益：" + max);
        return max;
    }

    /**
     * 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * @param k
     */
    public static void rotate(int k) {
        int[] nums = {4, 5, 6, 7, 8, 9};

        int a = 0;
        int b = k;

        for (int i = 0; i < nums.length; i++) {

            b = b % nums.length;
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b++;

        }


        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }
    }

    public static void a(){
        int[] a = {3,4,5,5,4,6,6,8,8,3,2};

        int r= 0;
        for(int i=0;i<a.length;i++){
            r ^= a[i];
        }
        System.out.println(r);

        System.out.println(0^4);
        System.out.println(4^3);
        System.out.println(7^3);
        System.out.println(7^4);
        System.out.println(0^4^4^3^7);
        System.out.println(0^2^3^5^2);
        System.out.println(2^3);
        System.out.println(2^3);
    }
}
