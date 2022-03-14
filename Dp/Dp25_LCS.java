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

		for(int i = 0; i<=m; i++)
		{
			for(int j = 0; j<= n; j++)
			{
				dp[i][j] = -1;
			}
		}

		//gives the length of the longest common subsequence
		System.out.println(lcs(m, n, s1, s2, dp));
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
}