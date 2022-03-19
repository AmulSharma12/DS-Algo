//LeetCode 44
// https://leetcode.com/problems/wildcard-matching/submissions/

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Dp34_WildCardMatching
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(isMatch(s1, s2));

	}

	 //recursive + memoise code
    public static boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        int[][] dp = new int[n][m];
        
        for(int[] currRow : dp)
        {
            Arrays.fill(currRow, -1);
        }
        return wcMatching(n-1, m-1, p, s, dp);
    }
    
    // recursive + memoize code
    public static boolean wcMatching(int i, int j, String x, String y, int[][] dp)
    {
        
        if(i<0 && j<0)
            return true;
        if(i<0 && j>=0)
            return false;
        if(j<0 && i>=0)
        {
            for(int l = 0; l<=i; l++)
            {
                char ch = x.charAt(l);
                if(ch != '*')
                    return false;
            }
            
            return true;
        }
        
        
        if(dp[i][j] != -1)
            return dp[i][j] == 0 ? false : true;
        
        //exploring all the possibilities
        if((x.charAt(i) == y.charAt(j))  || (x.charAt(i) == '?'))
        {
            boolean match = wcMatching(i-1, j-1, x, y, dp);
            dp[i][j] = match == false ? 0 : 1; 
            return match;
        }        
        //unmatch case
        if(x.charAt(i) == '*')
        {
            boolean unmatch = wcMatching(i-1, j, x, y, dp) || wcMatching(i, j-1, x, y,dp);
            dp[i][j] = unmatch == false ? 0  : 1;
            return unmatch;
        }
        
        dp[i][j] = 0;
        return false;
    }
}