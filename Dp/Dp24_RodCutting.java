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

		//dp filling in memoisation time to -1
		// for(int i = 0; i<n; i++)
		// {
		// 	for(int j = 0; j<=n; j++)
		// 	{
		// 		dp[i][j] = -1;
		// 	}
		// }

		//what will be the maximum price that can have

		// System.out.println(rodCutting(n-1, n, price, dp));
		// System.out.println(tabulation(price, n, dp));
		// System.out.println(spaceOpt2D(price, n));
		System.out.println(spaceOpt1D(price, n));
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
			take = price[ind] + rodCutting(ind, N-rodLength, price, dp);

		return dp[ind][N] = Math.max(take, notTake);
	}



	//tabulation
	public static int tabulation(int[] price, int N, int[][] dp)
	{
		//filling up the base case
		for(int n = 0; n<=N ; n++)
			dp[0][n] = N * price[0];


		//converting into nested lop
		for(int ind = 1; ind<N; ind++)
		{
			for(int n = 0; n<=N; n++)
			{
				int notTake = 0 + dp[ind-1][n];
				int take = Integer.MIN_VALUE;
				int rodLength = ind+1;

				if(rodLength <= n)
					take = price[ind] + dp[ind][n-rodLength];

				dp[ind][n] = Math.max(take, notTake);
			}
		}


		//last row last col
		return dp[N-1][N];
	}



	//space optimisation into 2d array
	public static int spaceOpt2D(int[] price, int N)
	{

		int[] prev = new int[N+1];
		int[] curr = new int[N+1];

		//filling up the base case
		for(int n = 0; n<=N ; n++)
			prev[n] = N * price[0];


		//converting into nested lop
		for(int ind = 1; ind<N; ind++)
		{
			for(int n = 0; n<=N; n++)
			{
				int notTake = 0 + prev[n];
				int take = Integer.MIN_VALUE;
				int rodLength = ind+1;

				if(rodLength <= n)
					take = price[ind] + curr[n-rodLength];

				curr[n] = Math.max(take, notTake);
			}

			//we not transfer after filling curr row
			prev = curr;
		}


		//last row last col
		return prev[N];
	}


	//space optimisation into 1d array
	public static int spaceOpt1D(int[] price, int N)
	{

		
		int[] curr = new int[N+1];

		//filling up the base case
		for(int n = 0; n<=N ; n++)
			curr[n] = N * price[0];


		//converting into nested lop
		for(int ind = 1; ind<N; ind++)
		{
			for(int n = 0; n<=N; n++)
			{
				int notTake = 0 + curr[n];
				int take = Integer.MIN_VALUE;
				int rodLength = ind+1;

				if(rodLength <= n)
					take = price[ind] + curr[n-rodLength];

				curr[n] = Math.max(take, notTake);
			}
		}


		//last row last col
		return curr[N];
	}
}