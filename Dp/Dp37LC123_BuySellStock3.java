// LeetCode 123
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

import java.util.Scanner;
public class Dp37LC123_BuySellStock3
{
	public static void main(String[] args)
	{
		int[] arr = {1,2, 3, 4, 5};
		System.out.println(maxProfit(arr));
	}


	 // function -maxProfit
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[][][] dp = new int[n][2][3];
        
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<2; j++)
            {
                for(int k = 0; k<3; k++)
                    dp[i][j][k] = -1;
            }
        }
        
        //format is like 0 is starting index and 1 as we have to buy first 
        return maxProf(0, 1, 2, dp, prices, n);
    }
    
    
    // Approach2 -> Memoisation solution TimeComplextiy - o(N*2*3) || SpaceComplexity - O(N*2*3) + O(N)
    public static int maxProf(int ind, int buy, int cap , int[][][] dp, int[] prices, int n)
    {
        
        //if all the stocks being exhausted then max profit is zero only
        if(ind == n || cap == 0)
            return 0;
        
        if(dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];
        
        int profit = 0;
        // exploring all the possibilites
        if(buy == 1)  // means we can buy/ not buy
        {
            profit = Math.max(-prices[ind] + maxProf(ind+1, 0, cap, dp, prices, n) , 0 + maxProf(ind+1, 1, cap, dp,  prices, n));
        }
        else
        {
            profit = Math.max(prices[ind] + maxProf(ind+1, 1, cap-1 , dp, prices, n) ,  0 + maxProf(ind+1, 0, cap,dp, prices, n));
        }
        
        return  dp[ind][buy][cap] = profit;
    }


    // Approach - 3 -> Tabulation Solution 
    public static int maxProf(int i, int buys, int transNo , int[][][] dp, int[] prices, int n)
    {
      
        // Step 1 -> Write the base case
        // as the base case returns zero which is already present bydefault
        
        // Step 2 -> Converting into nested loops and in opposite fashion
        // Step 3 ->  Copy the reccurence
        for(int ind = n-1; ind >= 0 ; ind--)
        {
            for(int buy = 0; buy <=1; buy++)
            {
                for(int cap = 1; cap<=2; cap++)
                {
                    int profit = 0;
                    // exploring all the possibilites
                    if(buy == 1)  // means we can buy/ not buy
                    {
                        profit = Math.max(-prices[ind] + dp[ind+1][0][cap] , 0 + dp[ind+1][1][cap]);
                    }
                    else
                    {
                        profit = Math.max(prices[ind] + dp[ind+1][1][cap-1] ,  0 + dp[ind+1][0][cap]);
                    }

                    dp[ind][buy][cap] = profit;
                }
            }
        }
        
      //return the ans as we start from first index  for the buying that is why 1
        return dp[0][1][2];
    }


    // Approach - 4 -> Space Optimisation TimeComplexity - O(N*2*3) || Space Complexity - O(2*3) almost constant
    public int maxProf(int buys, int transNo , int[] prices, int n)
    {
        int[][] ahead = new int[buys+1][transNo+1];
        int[][] curr = new int[buys+1][transNo+1];
        
        // just make changes dp[ind] -> curr and dp[ind+1] -> ahead
        for(int ind = n-1; ind >= 0 ; ind--)
        {
            for(int buy = 0; buy <=1; buy++)
            {
                for(int cap = 1; cap<=2; cap++)
                {
                    int profit = 0;
                    // exploring all the possibilites
                    if(buy == 1)  // means we can buy/ not buy
                    {
                        profit = Math.max(-prices[ind] + ahead[0][cap] , 0 + ahead[1][cap]);
                    }
                    else
                    {
                        profit = Math.max(prices[ind] + ahead[1][cap-1] ,  0 + ahead[0][cap]);
                    }

                    curr[buy][cap] = profit;
                }
            }
            
            
            //swap the references
            ahead = curr;
        }
        
      //return the ans as we start from first index  for the buying that is why 1
        return ahead[1][2];
    }
}