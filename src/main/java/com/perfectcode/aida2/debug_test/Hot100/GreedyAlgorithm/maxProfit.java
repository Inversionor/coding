package com.perfectcode.aida2.debug_test.Hot100.GreedyAlgorithm;

public class maxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // 如果数组为空或只有一个元素，无法进行交易，返回0
        }
        int minIndex = 0; // 用来记录迄今为止遇到的最低价格的索引
        int result = 0; // 用来记录最大利润
        for (int i = 1; i < prices.length; i++) { // 从第二个元素开始遍历
            if (prices[i] < prices[minIndex]) {
                minIndex = i; // 更新最低价格的索引
            } else if (prices[i] - prices[minIndex] > result) {
                result = prices[i] - prices[minIndex]; // 更新最大利润
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        maxProfit maxProfit = new maxProfit();
        System.out.println(maxProfit.maxProfit(prices));
    }
}
