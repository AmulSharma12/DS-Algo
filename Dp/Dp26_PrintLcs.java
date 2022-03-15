import java.util.Scanner;
import java.util.Arrays;

//printing the lcs -> longest common subsequence
public class Dp26_PrintLcs
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		String y = sc.nextLine();
		int n =  x.length();
		int m = y.length();

		int[][] dp = new int[n+1][m+1];
		StringBuilder result = new StringBuilder();

		//initialise with -1
		// for(int[] element : dp)
		// {
		// 	Arrays.fill(element, -1);
		// }


		//calling the lcs and filling the dp matrix
		lcsT(n, m, x, y, dp);

		int i = n;
		int j = m;

		while(i>0 && j>0)
		{
			if(x.charAt(i-1) == y.charAt(j-1))
			{
				result.append(x.charAt(i-1));
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1])
			{
				i--;
			}
			else
			{
				j--;
			}
		}


		//as we have start from the last so we will reverse the string at the last
		result.reverse();
		System.out.println(result);
	}



	//recursive + memoisation code
	public static int lcs(int n, int m, String x, String y, int[][] dp)
	{
		if(n == 0 || m == 0)
			return 0;

		if(dp[n][m] != -1)
			return dp[n][m];

		if(x.charAt(n-1) == y.charAt(m-1))
			return dp[n][m] = 1 + lcs(n-1, m-1, x , y, dp);
		return dp[n][m] = Math.max(lcs(n-1, m, x, y, dp) , lcs(n, m-1, x, y, dp));

	}


	// tabulation solution 
	public static int lcsT(int n, int m, String x, String y, int[][] dp)
	{
		//base case already fill to zero so no need

		// exploring all the possibility
		for(int i = 1; i<=n; i++)
		{
			for(int j = 1; j<=m; j++)
			{
				if(x.charAt(i-1) == y.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
			}
		}


		return dp[n][m];
	}
}