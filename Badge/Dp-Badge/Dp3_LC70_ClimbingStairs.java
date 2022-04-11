// https://leetcode.com/problems/climbing-stairs/
// LeetCode 70 Easy -> Climbing Stairs


import java.util.Scanner;
import java.util.Arrays;

public class Dp3_LC70_ClimbingStairs
{
	public static void main(String[] args)
	{
		int totalDistinctWays = climbStairs(2); //2
		System.out.println(totalDistinctWays);
	}


	// Approach 1 - Using Recursion
    public static  int climbStairs(int n) {
        return  climbRec(n);  
    }
    
    public static int climbRec(int n)
    {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        
        int oneStep = climbRec(n-1);
        int twoStep = climbRec(n-2);

        return oneStep + twoStep;
    }


    // Approach 2 - Using  Memoization
    public static int climbStairsM(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return  climbRec(n, dp);  
    }
    
    public static  int climbRec(int n, int[] dp)
    {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = climbRec(n-1, dp) + climbRec(n-2, dp);
    }


    // Approach 3 - Using Tabulation
    public static  int climbStairsT(int n) {
        int[] dp = new int[n+1];
        return  climbTab(n, dp);  
    }
    
    public static int climbTab(int n, int[] dp)
    {
       dp[0] = 1;
        
       for(int i = 1; i<=n; i++)
       {
           int oneStep = dp[i-1];
           int twoStep = 0;
           
           if(i >= 2)
               twoStep = dp[i-2];
           
           dp[i] = oneStep + twoStep;
       }
        
        return dp[n];
    }


    // Approach 4 - Using Space Optimization
    public static  int climbStairsS(int n) {
        return  climbSpaceOpt(n);  
    }
    
    
    
    public static int climbSpaceOpt(int n)
    {
        int prev = 1;
        int prev2 = 0;
        
       for(int i = 1; i<=n; i++)
       {
           int oneStep = prev;
           int twoStep = 0;
           
           if(i >= 2)
               twoStep = prev2;
           
           int curr = oneStep + twoStep;
           prev2 = prev;
           prev = curr;
       }
        
        return prev;
    }

}