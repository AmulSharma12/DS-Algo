// LeetCode 1092
// https://leetcode.com/problems/shortest-common-supersequence/submissions/
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Dp31_ShortestCommonSupersequence
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n+1][m+1];
		// for(int[] element : dp)
		// {
		// 	Arrays.fill(element, -1);
		// }

		// given two string we have to find the shortest common supersequence
		// my goal is to first find all the common subsequence of both string 
		// how we can achieve it by longest common subsequence
		lcsT(n, m, s1, s2, dp);

		int i = n;
		int j = m;

		StringBuilder result = new StringBuilder();
		while(i>0 && j>0)
		{
			if(s1.charAt(i-1) == s2.charAt(j-1))
			{
				result.append(s1.charAt(i-1));
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1])
			{
				result.append(s1.charAt(i-1));
				i--;
			}
			else
			{
				result.append(s2.charAt(j-1));
				j--;
			}
		}


		//in case of any character becomes empty so will copy all the element of the other strings
		while(i>0)
		{
			//this means j become 0 means s2 becomes empty
			result.append(s1.charAt(i-1));
			i--;
		}


		while(j>0)
		{
			// this says that i becomes 0 i.e. s1 becomes empty
			result.append(s2.charAt(j-1));
			j--;
		}


		//as we start fromt the last cell the result reverse will give the original result
		result.reverse();
		System.out.println(result.toString());

	}


	// using memoization filling dp table(or lcs table)
	public static int  lcs(int i, int j, String x, String y, int[][] dp)
	{
		if(i == 0 || j == 0)
			return 0;

		if(dp[i][j] != -1)
			return dp[i][j];

		if(x.charAt(i-1) == y.charAt(j-1))
			return dp[i][j] = 1 + lcs(i-1, j-1, x, y, dp);

		return dp[i][j] =  Math.max(lcs(i, j-1, x, y, dp), lcs(i-1, j, x, y, dp));
	}



	// using tabulation to create lcs table
	public static void lcsT(int n, int m, String x, String y, int[][] dp)
	{
		// as it is already filled with 0 so need of the base case

		//explore all the indexe
		for(int i = 1; i<=n; i++)
		{
			for(int j  = 1; j<=m; j++)
			{
				if(x.charAt(i-1) == y.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];

				else
					dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
			}
		}


		// result will be on the lcs length -> dp[n][m];
		return;
	}

}