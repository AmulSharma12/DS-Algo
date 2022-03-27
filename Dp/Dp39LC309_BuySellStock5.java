// LeetCode medium best time to buy and sell stock  
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

import java.util.Scanner;

public class Dp39LC309_BuySellStock
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 0, 2};  // maxProfit is 3
		System.out.println(maxProfit(arr));
	}

	//LeetCode 309 Medium Solution -> BestTime To BuyAndSellStock with cooldown
	// cooldown means you cannot buy just next day after selling the stock
	public static int maxProfit(int[] prices) {
        int n = prices.length;
          int[][] dp = new int[n][2];
          // int[][] dp = new int[n+2][2];
        
        
        for(int[] element : dp)
        {
            Arrays.fill(element, -1);
        }
        
        return maxProf(0, 1, prices, n);
    }
    
    
    // Approach 1 -> recursive Solution TIME COMPLEXITY : O(2^N) || Space Complexeity : O(N)
    // you have to notice once you complete transaction means buy and sell out the stock 
    // the very next day buy not allow for the buy you have to do after 2 days because next day not allow  
    public static int maxProf(int ind, int buy, int[] prices, int n)
    {
        //why greater because at max 2 steps can be taken if sell out the stock in n-1 day if sell it will reach n-1 n  n+1 so maxProfit wiill be 0
        if(ind >= n)
            return 0;
        
        //exploring all the possibilites
        //buying the stock allow -> Now your choice either you can buy or not buy the stock
        if(buy == 1)
            return Math.max(-prices[ind] + maxProf(ind+1, 0, prices, n)  , 0 + maxProf(ind+1, 1, prices, n));
        
        //now selling the stocks allow 
        return Math.max(prices[ind] + maxProf(ind+2, 1, prices, n) , 0 + maxProf(ind+1, 0, prices, n));
    }




     //Approach 2 -> Memoise solution 
    public static int maxProf(int ind, int buy, int[] prices, int n, int[][] dp)
    {
        //why greater because at max 2 steps can be taken if sell out the stock in n-1 day if sell it will reach n-1 n  n+1 so maxProfit wiill be 0
        if(ind >= n)
            return 0;
        
        if(dp[ind][buy] != -1)
            return dp[ind][buy];
        
        //exploring all the possibilites
        //buying the stock allow -> Now your choice either you can buy or not buy the stock
        if(buy == 1)
            return dp[ind][buy] = Math.max(-prices[ind] + maxProf(ind+1, 0, prices, n, dp)  , 0 + maxProf(ind+1, 1, prices, n, dp));
        
        //now selling the stocks allow 
        return dp[ind][buy] = Math.max(prices[ind] + maxProf(ind+2, 1, prices, n, dp) , 0 + maxProf(ind+1, 0, prices, n, dp));
    }




     //Approach 3 -> Tabulation Solution 
    public static int maxProf(int startIndex, int buyStock, int[] prices, int n, int[][] dp)
    {
        // Max value of index is n-1 and then 2 steps means n-1 n n+1  means n+2 size require so that n+1 index available 
        // so base case return 0 which is already by default present so no need to fill 
        
         // Step 2  converting into nested loops and in opposite fashion
         // ind 0-> n-1 convert into n-1 -> 0
         // buy 1 -> 0  convert into 0(sell) -> 1(buy)
        
        
        for(int ind = n-1; ind >= 0 ; ind--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {
               //exploring all the possibilites
                //buying the stock allow -> Now your choice either you can buy or not buy the stock
                if(buy == 1)
                     dp[ind][buy] = Math.max(-prices[ind] + dp[ind+1][0]  , 0 + dp[ind+1][1]);

                //now selling the stocks allow 
                else 
                    dp[ind][buy] = Math.max(prices[ind] +dp[ind+2][1] , 0 + dp[ind+1][0]);
            }
        }
        
       
        //ans will be we start from 0 th index and for buy we intially arrives
        return dp[0][1];
    }


    


}



