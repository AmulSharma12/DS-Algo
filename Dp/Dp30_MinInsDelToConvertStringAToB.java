import java.util.Scanner;
import java.util.Arrays;

public class Dp30_MinInsDelToConvertStringAToB
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s1 = "abcd";
		String s2 = "anc";

		System.out.println(conversion(s1, s2));
	}


	public static int conversion(String x, String y)
	{
		int n  = x.length();
		int m = y.length();

		// extra character in x to be deleted and extra character in y to be inserted
		// int del = n - lcs(x, y);
		// int ins = m - lcs(x, y);

		return n + m - 2 * lcs(x, y);
	}


	public static int lcs(String x , String y)
	{
		int n = x.length();
		int m = y.length();

		int[][] dp = new int[n+1][m+1];
		// for(int[] element : dp)
		// {
		// 	Arrays.fill(element , -1);
		// }


		return lcsT(n, m, x, y, dp);
	}


	public static int lcsR(int i, int j, String x, String y, int[][] dp)
	{
		if(i == 0 || j == 0)
			return 0;

		if(dp[i][j] != -1)
			return dp[i][j];

		if(x.charAt(i-1) == y.charAt(j-1))
			return dp[i][j] =  1 + lcsR(i-1, j-1, x, y, dp);

		return dp[i][j] = Math.max(lcsR(i, j-1, x, y, dp) , lcsR(i-1, j, x, y, dp));
	}


	public static int lcsT(int n, int m, String x, String y, int[][] dp)
	{
		// base case already filled to 0 so needed

		//explore all the stuff on that index
		for(int i = 1; i<=n; i++)
		{
			for(int j = 1; j<=m ; j++)
			{
				if(x.charAt(i-1) == y.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
			}
		}


		//return the length of the longest common subsequence
		return dp[n][m];
	}
}