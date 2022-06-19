// LeetCode 300 medium Longest Increasing subsequence 
// https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.Scanner;
import java.util.Arrays;
public class Dp41LC300_LongestIncreasingSubsequence
{
	public static void main(String[] args)
	{
		int[] arr = {0, 1, 0, 3, 2, 3};
		System.out.println(lengthOfLIS(arr));
	}


	 public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int[][] dp = new int[n][n+1];
        
        for(int[] element : dp)
            Arrays.fill(element , -1);
        
        return lis(0, -1, nums, n, dp);
    }
    
    // Approach 1 - Using recursion +  Using memoisation
    public static int lis(int ind , int prevIndex, int[] nums ,int n, int[][] dp)
    {
        if(ind == n)
            return 0;
        
        if(dp[ind][prevIndex+1] != -1)
            return dp[ind][prevIndex+1];
        
        // notTake call
        int length = 0 + lis(ind+1, prevIndex, nums, n, dp);
        
        //take call
        if(prevIndex == -1 || nums[ind] > nums[prevIndex])
        length = Math.max(length, 1 + lis(ind+1, ind, nums, n, dp));
        
        return dp[ind][prevIndex+1] =  length;
    }


    //Approach 2 Using Tabulation
    public static  int lis(int[] nums ,int n, int[][] dp)
    {
     
        for(int ind = n-1; ind>=0; ind--)
        {
            for(int prevIndex = ind-1; prevIndex >= -1; prevIndex--)
            {
                // notTake call
                int length = 0 + dp[ind+1][prevIndex+1];

                //take call
                if(prevIndex == -1 || nums[ind] > nums[prevIndex])
                    length = Math.max(length, 1 + dp[ind+1][ind+1]);
                
                dp[ind][prevIndex+1] = length;
                
            }
        }
        
        
        return dp[0][-1+1];
    }


    // Approach 3 Space Optimisation
    public static int lis(int[] nums ,int n)
    {
        int[] curr = new int[n+1];
        int[] next = new int[n+1];
     
        for(int ind = n-1; ind>=0; ind--)
        {
            for(int prevIndex = ind-1; prevIndex >= -1; prevIndex--)
            {
                // notTake call
                int length = 0 + next[prevIndex+1];

                //take call
                if(prevIndex == -1 || nums[ind] > nums[prevIndex])
                    length = Math.max(length, 1 + next[ind+1]);
                
                curr[prevIndex+1] = length;
                
            }
            int[] temp = next;
            next = curr;
            curr = temp;
        }
        
        
        return next[-1+1];
    }


}