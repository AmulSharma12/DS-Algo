// rod cutting problem you will be give n and array n -> dentoes the length of the rod
import java.util.Scanner;
import java.util.Arrays;

public class Dp24_RodCutting
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] price = new int[n];

		for(int i = 0; i<n; i++)
		{
			price[i] = sc.nextInt();
		}

		int[][] dp =  new int[n][n+1];

		for(int i = 0; i<n; i++)
		{
			for(int j = 0; j<=n; j++)
			{
				dp[i][j] = -1;
			}
		}

		//what will be the maximum price that can have

		System.out.println(rodCutting(n-1, n, price, dp));
	}



	//recursive + memoise solution -> dp of changing variable with their max value size 
	public static int rodCutting(int ind , int N, int[] price, int[][] dp)
	{
		//at index 0 means rod of length 1 so how many rod needed to make N
		if(ind == 0)
		{
			return N * price[0];
		}


		if(dp[ind][N] != -1)
			return dp[ind][N];

		//exploring all the index
		int notTake = 0 + rodCutting(ind-1, N, price, dp);
		int rodLength = ind + 1;
		int take = Integer.MIN_VALUE;
		if(rodLength <= N)
			take = price[ind] + rodCutting(ind-1, N-rodLength, price, dp);

		return dp[ind][N] = Math.max(take, notTake);
	}
}