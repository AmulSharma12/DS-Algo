// https://leetcode.com/problems/jump-game-ii/
// LeetCode 45 Medium JumpGame2

import java.util.Scanner;
import java.util.Arrays;


public class Dp9_LC45_JumpGame2
{
	public static void main(String[] args)
	{
		//function_call()
	}


	  //recursive way
    public static  int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp , -1);
        
        //you can start from 0th index
        return minJumps(0, dp,  nums,  n-1);
    }
    
    
    public static int minJumps(int ind,int[] dp, int[] nums,  int n)
    {
        if(ind > n)
            return (int)Math.pow(10,8);
        if(ind == n)
            return 0;
        
        if(nums[ind] == 0)
            return (int)Math.pow(10, 8);
        
        if(dp[ind] != -1)
            return dp[ind];
            
        
        int mini = Integer.MAX_VALUE;
        int jumpIndex = 0;
        for(int jump = 1; jump<= nums[ind] ; jump++)
        {
            jumpIndex = 1 + minJumps(ind+jump, dp,  nums, n);
            mini = Math.min(mini, jumpIndex);
        }
        
        
        return dp[ind] = mini;
    }
}