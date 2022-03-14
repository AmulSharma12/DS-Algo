// PATTERN 3 -> DP ON STRINGS

// ------------------------------------
//LCS -> return the length of the length of the longest common subsequence
import java.util.Scanner;
import java.util.Arrays;

public class Dp25_LCS
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);   
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];

		// for(int i = 0; i<=m; i++)
		// {
		// 	for(int j = 0; j<= n; j++)
		// 	{
		// 		dp[i][j] = -1;
		// 	}
		// }

		//gives the length of the longest common subsequence
		// System.out.println(lcs(m, n, s1, s2, dp));
		System.out.println(tabulation(m, n, s1, s2, dp));
		System.out.println(spaceOptimization2D(m, n, s1, s2));
	}


	// recursion + memoisation solution
	public static int lcs(int i, int j, String x, String y, int[][] dp)
	{
		if(i == 0 || j == 0)
			return 0;

		if(dp[i][j] != -1)
			return dp[i][j];


		if(x.charAt(i-1) == y.charAt(j-1))
			return dp[i][j] = 1 + lcs(i-1, j-1, x, y, dp);
		return dp[i][j] = Math.max(lcs(i, j-1, x, y, dp) , lcs(i-1, j, x, y, dp));
	}




	// tabulation -> solution
	public static int tabulation(int m, int n, String x, String y, int[][] dp)
	{

		//base cases
		for(int j = 0; j<=n; j++)
			dp[0][j] = 0;

		for(int i = 0; i<=m; i++)
			dp[i][0] = 0;


		//exploring all the index
		for(int i = 1; i<=m; i++)
		{
			for(int j = 1; j<=n; j++)
			{
				if(x.charAt(i-1) == y.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];

				else
					dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
			}
		}



		//return the result
		return dp[m][n];


	}



	// space optimisation
	public static int spaceOptimization2D(int m, int n, String x, String y)
	{
		int[] prev = new int[n+1];
		int[] curr = new int[n+1];

		// base case
		for(int j = 0; j<=n; j++)
			prev[j] = 0;

		
		//exploring all the index
		for(int i = 1; i<=m; i++)
		{
			for(int j = 1; j<=n; j++)
			{
				if(x.charAt(i-1) == y.charAt(j-1))
					curr[j] = 1 + prev[j-1];

				else
					curr[j] = 0 + Math.max(prev[j] , curr[j-1]);
			}

			prev = curr;
		}



		//return the result
		return prev[n];  

	}
}