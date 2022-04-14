// https://leetcode.com/problems/house-robber-ii/
// LeetCode 213 Medium house robber 2 solution

import java.util.Scanner;
import java.util.Arrays;

public class Dp6_LC213_HouseRobber2
{
	public static void main(String[] args)
	{
		//function call
	}


	 //--------------------------------------------- Approach 1- Using recursion
    public static int rob(int[] nums) {
       int n = nums.length;
        if(n == 1)
            return nums[0];
        
        //leaving last element checking remaining part 
        int forwardPart = robHouse(0, n-2, nums);
        //leaving first elment checking remaining part
        int backwardPart = robHouse(1, n-1, nums);
        
        return Math.max(forwardPart, backwardPart);
    }
    
    
    public static int robHouse(int low, int high, int[] nums)
    {
        if(high < low)
            return 0;
        if(high == low)
            return nums[low];
        
        //rob all the house -> explore all the index
        int rob = nums[high] + robHouse(low, high-2, nums);
        int notRob = 0 + robHouse(low, high-1, nums);
        return Math.max(rob, notRob);
    }


     //------------------------------------------------- Approach 2- Using Memoization
    public static int robM(int[] nums) {
       int n = nums.length;
        if(n == 1)
            return nums[0];
        
        int[] dp = new int[n];
        Arrays.fill( dp, -1);
        
        //leaving last element checking remaining part 
        int forwardPart = robHouseM(0, n-2, nums, dp);
        
        Arrays.fill(dp, -1);
        //leaving first elment checking remaining part
        int backwardPart = robHouseM(1, n-1, nums, dp);
        
        return Math.max(forwardPart, backwardPart);
    }
    
    
    public static int robHouseM(int low, int high, int[] nums, int[] dp)
    {
        if(high < low)
            return 0;
        if(high == low)
            return nums[low];
        
        
        if(dp[high] != -1)
            return dp[high];
        
        //rob all the house -> explore all the index
        int rob = nums[high] + robHouse(low, high-2, nums, dp);
        int notRob = 0 + robHouse(low, high-1, nums, dp);
        return dp[high] = Math.max(rob, notRob);
   }



   
}