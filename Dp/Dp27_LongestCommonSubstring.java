import java.util.Scanner;
import java.util.Arrays;

public class Dp27_LongestCommonSubstring
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		String y = sc.nextLine();
		int n = x.length();
		int m = y.length();
		int[][] dp = new int[n+1][m+1];


		//initialise with -1
		// for(int[] element : dp)
		// {
		// 	Arrays.fill(element , -1);
		// }

		int result = longestCommonSubstring(n, m, x, y, dp);
		System.out.println(result);

	}


	// tabulation approach
	public static int longestCommonSubstring(int n, int m, String x, String y, int[][] dp)
	{
		// base case already filled with 0 for empty strings
		int ans = Integer.MIN_VALUE;

		// explore all the possiblities
		for(int i = 1; i<=n; i++)
		{
			for(int j = 1; j<=m; j++)
			{
				if(x.charAt(i-1) == y.charAt(j-1))
				{
					dp[i][j] = 1  + dp[i-1][j-1];
					ans = Math.max(ans, dp[i][j]);
				}	

				else
					dp[i][j] = 0;
			}
		}

		return ans;

	}
}