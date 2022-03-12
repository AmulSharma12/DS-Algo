import java.util.Scanner;
import java.util.Arrays;

public class Dp17_CountSubsetsWithSumK
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i = 0; i<n; i++)
		{
			arr[i] = sc.nextInt();
		}

		//taking target as input
		int target = sc.nextInt();

		int[][] dp = new int[n][target+1];
		// for(int[] element : dp)
		// {
		// 	Arrays.fill(element, -1);
		// }


		System.out.println("--------------------No of subset sum as k---------------");
		// System.out.println(countSubset(arr, n, n-1, target, dp));
		// System.out.println(tabulation(arr, n, target, dp));
		System.out.println(spaceOptimisation(arr, n, target));
	}



	//recursive + memoise solution
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




	//tabulation solution
	public static int tabulation(int[] nums, int n, int target, int[][] dp)
	{
		// writing base case
		for(int i = 0; i<n; i++)
		 	dp[i][0] = 1;

		 if(nums[0] <= target) 	dp[0][nums[0]] = 1;




		 //step 2 : convert into nested loops 
		 for(int index = 1; index<n; index++)
		 {
		 	for(int tar = 0; tar <= target; tar++)
		 	{
		 		int notTake = dp[index-1][tar];
		 		int take = 0;
		 		if(nums[index]<= tar)
		 			take = dp[index-1][tar-nums[index]];

		 		dp[index][tar] = take + notTake;
		 	}
		 }


		 return dp[n-1][target];

	}



	// spcae optimisation
	public static int spaceOptimisation(int[] nums, int n, int target)
	{
		int[] prev = new int[target+1];
		int[] curr = new int[target+1];


		
		prev[0] = 1;

		curr[0] = 1;
		if(nums[0] <= target)
			prev[nums[0]] = 1;


		for(int ind = 1; ind<n; ind++)
		{
			for(int tar = 0; tar<= target; tar++)
			{
				int notTake = prev[tar];
				int take = 0;
				if(nums[ind] <= tar)
					take = prev[tar-nums[ind]];

				curr[tar] = take+ notTake;
			}

			prev = curr;
		}


		return prev[target];
	}
}