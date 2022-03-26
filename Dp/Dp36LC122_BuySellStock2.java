// LeetCode 122 Medium Buy and Sell Stock 2
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/

import java.util.Scanner;
import java.util.Arrays;

public class Dp36LC122_BuySellStock2
{
	public static void main(String[] args)
	{
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}


	//recursive + memoisation solution 
	public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        
        for(int[] element : dp)
        {
            Arrays.fill(element, -1);
        }
        
        return maxProf(0, 1, prices, n, dp);
    }
    
    
    //recursive + memoisation
    public static  int maxProf(int ind, int buy, int[] price, int n, int[][] dp)
    {
        //when all stock get exhausted no more items are left the max profit is going to be zero
        if(ind == n)
            return 0;
        
        
            
        if(dp[ind][buy] != -1)
            return dp[ind][buy];
        
        int profit = 0;
        //exploring all the possibilities
        if(buy == 1)
            profit = Math.max(-price[ind] + maxProf(ind+1, 0, price, n, dp) , 0 + maxProf(ind+1, 1, price, n, dp));
        else
            profit = Math.max(price[ind] + maxProf(ind+1, 1, price, n, dp) , 0 + maxProf(ind+1, 0, price, n, dp));
        
        return dp[ind][buy] =  profit;
          
    }

	

	 //tabulation solution -> Time complexity -> O(N*2) || Space Complextiy -> O(N*2) 
    public static int maxProf(int[] price, int n, int[][] dp)
    {
       //base case for ind == n maxProfit will be 0
        dp[n][0] = 0;
        dp[n][1] = 0;
        
        for(int ind = n-1 ; ind >= 0; ind--)
        {
            for(int buy = 0; buy<=1; buy++)
            {
                int profit = 0;
                if(buy == 1)
                    profit = Math.max(-price[ind] + dp[ind+1][0], 0 + dp[ind+1][1]);
                else
                    profit = Math.max(price[ind] + dp[ind+1][1] , 0+ dp[ind+1][0]);
                
                dp[ind][buy] = profit;
            }
        }
        
        return dp[0][1];
          
    }


    //Space Optimisation TIME COMPLEXITY : O(N*2) || Space Complexity : O(4) ~O(1)
    public static int maxProf(int[] price, int n)
    {
        int[] ahead = new int[2];
        int[] curr = new int[2];
       //base case for ind == n maxProfit will be 0
        ahead[0] = 0;
        ahead[1] = 0;
        
        for(int ind = n-1 ; ind >= 0; ind--)
        {
            for(int buy = 0; buy<=1; buy++)
            {
                int profit = 0;
                if(buy == 1)
                    profit = Math.max(-price[ind] + ahead[0], 0 + ahead[1]);
                else
                    profit = Math.max(price[ind] + ahead[1] , 0+ ahead[0]);
                
                curr[buy] = profit;
            }
            
            ahead  = curr;
        }
        
        return ahead[1];
          
    }


      //Using 4 variable solution -> Time Complextiy O(N*2) || Space Complextiy
    public static int maxProf(int[] price, int n)
    {
        int aheadNotBuy = 0;
        int aheadBuy = 0; 
        
        for(int ind = n-1 ; ind >= 0; ind--)
        {
            for(int buy = 0; buy<=1; buy++)
            {
                int currBuy = Math.max(-price[ind] + aheadNotBuy  , 0 + aheadBuy);
                int currNotBuy = Math.max(price[ind] + aheadBuy , 0+ aheadNotBuy);
                aheadNotBuy = currNotBuy;
                aheadBuy = currBuy;
            }
        }
        
        return aheadBuy;
          
    }
}