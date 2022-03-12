import java.util.Scanner;
import java.util.Arrays;

// s1 + s2 = sumofarray

// we have to relate the problem into something with similar one subset sum 
// s1 - s2 = diff
// (sumOfArray-s2)-s2 = diff
//  sumOfArray-2s2 = diff
// s2 =  (sumOfArray-diff)/2


public class Dp18_CountSubsetWithDifference
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i<n; i++)
			arr[i] =sc.nextInt();

		int diff = sc.nextInt();

		//approach  we have to calculate the no of way subset sum with equal to the difference
		int totSum = 0;
		for(int i = 0; i<n; i++)
			totSum += arr[i];

		if((totSum-diff) < 0 || (totSum-diff)%2 != 0)
			System.out.println("not possible");
		else
		{
			System.out.println(findWays(arr,( totSum-diff)/2));
		} 
	}


	public static int findWays(int[] arr, int target)
	{
		int n = arr.length;
		int[][] dp = new int[n][target+1];

		for(int i = 0; i<n; i++)
		{
			for(int j = 0; j<=target; j++)
			{
				dp[i][j] = -1;
			}
		}
		return countSubset(arr, n, n-1, target, dp);
	}


	public static int countSubset(int[] nums, int n, int index, int target, int[][] dp)
	{

		if(target == 0)
			return 1;

		//step 1 : base case
		if(index == 0)
		{
			if(nums[index] == target)
				return 1;
			else
				return 0;
		}

		if(dp[index][target] != -1)
			return dp[index][target];


		//step 2 : exploring all the stuff on that index
		int notTake = countSubset(nums, n, index-1, target, dp); 
		int take = 0;
		if(nums[index] <= target) take = countSubset(nums, n,index-1, target - nums[index], dp);


		//step 3 : return the total of all the ways
		return dp[index][target] = take + notTake;
	}
}