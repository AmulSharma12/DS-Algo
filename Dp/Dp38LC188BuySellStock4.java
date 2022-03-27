// LeetCode 188 Hard Buy Sell Stock just like we did in atmost k transactions
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

import java.util.Scanner;
import java.util.Arrays;

public class Dp38LC188BuySellStock4
{
	public static void main(String[] args)
	{
		int[] arr = {2, 4, 1};
		int k = 2;
		int result = maxProfit(k, arr);
		System.out.println(result);
	}

	// maxProfit function
	public static int maxProfit(int k, int[] prices)
	{
      int n = prices.length;
      return maxProf(0, 1, k, prices, n);
    }
    
    
    // Approach -1  Recursive Solution
    public static int maxProf(int ind, int buy, int cap, int[] prices, int n)
    {
        //if we have reach when no stock left or either we have complete transactions then maxProfit is zero
        if(ind == n || cap == 0)
            return 0;
        
        //exploring all the possibilites
        if(buy == 1)
           return  Math.max(-prices[ind] + maxProf(ind+1, 0, cap, prices, n) , 0 + maxProf(ind+1, 1, cap, prices, n));
        
        
        return Math.max(prices[ind] + maxProf(ind+1, 1, cap-1, prices, n) , 0 + maxProf(ind+1, 0, cap, prices, n));
        
        
    }
}