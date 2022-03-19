// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// LeetCode 121

import java.util.Scanner;
import java.util.Arrays;
public class Dp35_BuySellStock
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] prices = new int[n];

		for(int i = 0; i<n; i++)
			prices[i] = sc.nextInt();

		System.out.println(maxProfit(prices));
	}


	public static  int maxProfit(int[] prices) {
        int n = prices.length;
        
        int mini = prices[0];
        int profit = 0;
        for(int i = 0; i<n; i++)
        {
            int cost = prices[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, prices[i]);
        }
        
        
        return profit;
    }
}