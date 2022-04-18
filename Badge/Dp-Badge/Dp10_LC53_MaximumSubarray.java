// https://leetcode.com/problems/maximum-subarray/
// LeetCode 53 easy Maximum Subarray 

import java.util.Scanner;
import java.util.Arrays;

public class Dp10_LC53_MaximumSubarray
{
	public static void main(String[] args)
	{
		//function_call();
	}


	 // Approach 3 - Using O(N)  Kadane algorithim will eliminate the negative subarray sum
    public static int maxSubArray(int[] nums) {
      int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i<n; i++)
        {
            sum += nums[i];
            maxi = Math.max(maxi, sum);
            if(sum < 0)     sum = 0;
        }
        
        
        return maxi;
    }
}