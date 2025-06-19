package Arrays_leetcode;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock_2_122 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();
    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
