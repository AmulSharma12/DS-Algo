import java.util.Scanner;
import java.util.Arrays;

public class Dp28_LongestPalindromicSubsequence
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		int result = longestPalindromeSubseq(x);
		System.out.println(result);

	}


	// recursive + memoisation solution
		 public static int longestPalindromeSubseq(String s) {
	        String rev = new StringBuilder(s).reverse().toString();
	        int lps = lcs(s, rev);
	        return lps;   
	    }


		public static int lcs(String x, String y)
		    {
		        int n = x.length();
		        int m = y.length();
		        int[][] dp = new int[n+1][m+1];
		        
		        for(int[] element : dp)
		        {
		            Arrays.fill(element, -1);
		        }
		        return lcsR(n, m, x, y, dp);
		    }
    
    
    public static int lcsR(int i, int j, String x, String y, int[][] dp)
    {
        if(i == 0 || j == 0)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(x.charAt(i-1) == y.charAt(j-1))
            return dp[i][j] = 1 + lcsR(i-1, j-1, x, y, dp);
        
        return dp[i][j] = Math.max(lcsR(i, j-1, x, y, dp), lcsR(i-1, j, x, y, dp));
    }

}