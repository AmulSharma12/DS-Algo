// https://leetcode.com/problems/jump-game/
// LeetCode 55 Medium Jump Game

import java.util.Scanner;
import java.util.Arrays;

public class Dp8_LC55_JumpGame
{
	public static void main(String[] args)
	{
		//function call -> it returns whether we will able to move till last index or not
	}

	// LeetCode 55 JumpGame Solution
	 // Approach 1 - using recursion
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return true;
        int[] dp = new int[n];
        
        return jumpPossible(0, nums, n-1, dp);
    }
    
    
    public static boolean jumpPossible(int ind, int[] nums, int dest, int[] dp)
    {
       if(ind == dest)
           return true;
        
        if(nums[ind] == 0)
        {
            dp[ind] = 0;
            return false;
        }
        
        
        if(dp[ind] != -1)
            return dp[ind] == 0 ? false : true;
        
        int jumps = nums[ind];
        for(int index = 1; index <= jumps; index++)
        {
            if(jumpPossible(ind+index, nums, dest, dp))
            {
                dp[ind] = 1;
                return true;
            }
        }
        
        dp[ind] = 0;
        return false;
    }


    //Approach 2 - Using Greedy Algorithim
}