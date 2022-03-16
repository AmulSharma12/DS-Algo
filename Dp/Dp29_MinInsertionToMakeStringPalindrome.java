import java.util.Scanner;
import java.util.Arrays;

public class Dp29_MinInsertionToMakeStringPalindrome
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		System.out.println(minInsertion(s));

	}


	public static int minInsertion(String s)
	{
		String rev = new StringBuilder(s).reverse().toString();
		int n = s.length();
		int m = n;
		int[][] dp = new int[n+1][m+1];
		for(int[] element : dp)
		{
			Arrays.fill(element, -1);
		}

		// total length - longest palindrome subsequence
		return n - lps(n, m,s, rev, dp);
	}


	//lps function to calculate length of the longest palindrome subsequence
	public static int lps(int i, int j , String x, String y, int[][] dp)
	{
		if( i == 0 || j == 0)
			return 0;

		if(dp[i][j] != -1)
			return dp[i][j];

		if(x.charAt(i-1) == y.charAt(j-1))
			return dp[i][j] = 1 + lps(i-1, j-1, x, y, dp);
		
		return dp[i][j] = Math.max(lps(i, j-1, x, y, dp), lps(i-1, j, x, y, dp));
	}
}