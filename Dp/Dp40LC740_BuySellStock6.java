// LeetCode 714 Medium - > Buy Sell Stock with transaction fee
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

// transaction fee is done when you done up with each transaction(buy-> sell) 

import java.util.Scanner;

public class Dp40LC740_BuySellStock
{
	public static void main(String[] args)
	{
		int[] arr = {1, 3, 2 , 8, 4, 9};
		int n = arr.length;
		int fee = 2;

		//maxProfit = 8

		System.out.println(maxProfit(0, 1, fee, arr, n));
	}


	// LeetCode 714 solution medium BuySellStock5
	 public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
         int[][] dp = new int[n][2];
        
        for(int[] element : dp)
        {
            Arrays.fill(element, -1);
        }

        //  int[][] dp = new int[n+1][2];
        
        return maxProf(0, 1, fee, prices, n);
        
    }
    
    
    // Approach 1 Using recursive way 
    public static int maxProf(int ind, int buy, int fee, int[] prices, int n)
    {
        if(ind == n)
            return 0;
        
        
        //if buying is allow either they will buy or not buy
        if(buy ==  1)
            return Math.max(-prices[ind] + maxProf(ind+1, 0,fee,  prices, n)  ,  0 + maxProf(ind+1, 1,fee, prices, n));
            
        //now sell the stock is allow either you sell it or not thats up to you
        // As while stock sell out the transaction fee should be cut at the same time
        return Math.max(prices[ind] -fee +  maxProf(ind+1, 1, fee, prices, n) , 0 + maxProf(ind+1, 0, fee, prices, n));
    }


     // Approach 2 Using Memoise way  TC: O(N*2) || SC: O(N*2) + O(N)
    public static int maxProf(int ind, int buy, int fee, int[] prices, int n, int[][] dp)
    {
        if(ind == n)
            return 0;
        
        if(dp[ind][buy] != -1)
            return dp[ind][buy];
        
        //if buying is allow either they will buy or not buy
        if(buy ==  1)
            return dp[ind][buy] = Math.max(-prices[ind] + maxProf(ind+1, 0,fee,  prices, n, dp)  ,  0 + maxProf(ind+1, 1,fee, prices, n, dp));
            
        //now sell the stock is allow either you sell it or not thats up to you
        // As while stock sell out the transaction fee should be cut at the same time
        return dp[ind][buy] = Math.max(prices[ind] -fee +  maxProf(ind+1, 1, fee, prices, n, dp) , 0 + maxProf(ind+1, 0, fee, prices, n, dp));
    }


    // Approach 3 Using Tabulation way  TC: O(N*2) || SC: O(N*2) 
    public  static int maxProf(int indF, int buyF, int fee, int[] prices, int n, int[][] dp)
    {
        // we dont have to do for the base case as it return 0 and we already have bydefault value of 0
        
        
        // Step 2 : convert into nested looops and write in the opposite fashion
        for(int ind = n-1; ind>=0; ind--)
        {
            for(int buy = 0; buy <=1; buy++)
            {
                if(buy ==  1)
                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind+1][0]  ,  0 + dp[ind+1][1]);
                else
                    dp[ind][buy] = Math.max(prices[ind] -fee +  dp[ind+1][1] , 0 + dp[ind+1][0]);
                
            }
        }
        
       //return the ans which is start from 0th index and with allowance of buy
        return dp[0][1];
    }


    // Approach 4 Using Space Optimisation way  TC: O(N*2) || SC: O(2) + O(2)
    // return maxProf(fee, prices, n);
    public static int maxProf(int fee, int[] prices, int n)
    {
       // Step 1  create 2 array curr and ahead
        int[] curr = new int[2];
        int[] ahead = new int[2];
        
        
        // Step 2 : convert into nested looops and write in the opposite fashion
        for(int ind = n-1; ind>=0; ind--)
        {
            for(int buy = 0; buy <=1; buy++)
            {
                if(buy ==  1)
                    curr[buy] = Math.max(-prices[ind] + ahead[0]  ,  0 + ahead[1]);
                else
                    curr[buy] = Math.max(prices[ind] -fee +  ahead[1] , 0 + ahead[0]);
                
            }
            ahead = curr;
        }
        
       //return the ans which is start from 0th index and with allowance of buy
        return ahead[1];
    }
}