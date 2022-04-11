import java.util.Scanner;
import java.util.Arrays;

public class Dp4_LC746_MinCostClimbingStairs
{
	public static void main(String[] args)
	{
		int result = minCostClimbingStairs(new int[] {10, 15, 20});
		System.out.println(result);
	}


	 //------------------------------------- Approach 1 -Using Recursion
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int zeroInd =  minCost(0, cost, n);
        int firstInd = minCost(1, cost, n);
        
        return Math.min(zeroInd , firstInd);
        
    }
    
    
    public static int minCost(int ind, int[] cost, int n)
    {
       if(ind >= n)
           return 0;
        
        int oneStep = cost[ind] + minCost(ind + 1, cost, n);
        int twoStep = cost[ind] + minCost(ind + 2, cost, n);
        
        return Math.min(oneStep, twoStep);
    }


    //--------------------------------------- Approach 2 - Using Memoization
    public static int minCostClimbingStairsM(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+2];
        Arrays.fill(dp, -1);
        int zeroInd =  minCost(0, cost, n, dp);
        
        Arrays.fill(dp, -1);
        int firstInd = minCost(1, cost, n, dp);
        
        return Math.min(zeroInd , firstInd);
        
    }
    
    
    public static int minCost(int ind, int[] cost, int n, int[] dp)
    {
       if(ind >= n)
           return 0;
        
        if(dp[ind] != -1)
            return dp[ind];
        
        int oneStep = cost[ind] + minCost(ind + 1, cost, n, dp);
        int twoStep = cost[ind] + minCost(ind + 2, cost, n, dp);
        
        return  dp[ind] = Math.min(oneStep, twoStep);
    }


    // ------------------------------------------------ Approach 3 - Using Tabulation
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+2];
        int zeroInd =  minCost(0,cost, n, dp);
        int firstInd = minCost(1,cost, n, dp);
        
        return Math.min(zeroInd , firstInd);
        
    }
    
    
    public static int minCost(int index, int[] cost, int n, int[] dp)
    {
        dp[n] = 0;
        dp[n+1] = 0;
    
        for(int ind = n-1 ;ind >=0; ind--)
        {
             int oneStep = cost[ind] + dp[ind+1];
             int twoStep = cost[ind] + dp[ind+2];
             dp[ind] = Math.min(oneStep, twoStep);
        }
        
        
        return dp[index];
    }



    // ------------------------------------ Approach 4 -Using space Optimization
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+2];
        int zeroInd =  minCost(0,cost, n, dp);
        int firstInd = minCost(1,cost, n, dp);
        
        return Math.min(zeroInd , firstInd);
        
    }
    
    
    public static int minCost(int index, int[] cost, int n, int[] dp)
    {
        int next = 0;
        int secondNext = 0;
    
        for(int ind = n-1 ;ind >=index; ind--)
        {
             int oneStep = cost[ind] + next;
             int twoStep = cost[ind] + secondNext;
             int curr = Math.min(oneStep, twoStep);
             secondNext = next;
             next = curr;
        }
        
        
        return next;
    }

}