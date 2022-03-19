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


    //tabulation approach
     public static boolean wcMatching(int n, int m, String x, String y)
    {
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        
        for(int j = 1; j<=m; j++)
            dp[0][j] = false;
        
      
        //base case - 3
        for(int i = 1; i<=n; i++)
        {
            boolean flag = true;
            for(int l = 1; l<=i; l++)
            {
                if(x.charAt(l-1) != '*')
                {
                    flag = false;
                    break;
                }
            }
            
            dp[i][0] = flag;
        }
        
        
       
        //filling dp table
        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                //exploring all the possibilities
                if((x.charAt(i-1) == y.charAt(j-1))  || (x.charAt(i-1) == '?'))
                {
                    dp[i][j]  = dp[i-1][j-1];
                   
                }        
                //unmatch case
                else if(x.charAt(i-1) == '*')
                {
                    dp[i][j]  = dp[i][j-1] || dp[i-1][j];
                }

                else dp[i][j] = false;
             } 
        }
        
        
        return dp[n][m];
    }


    // space optimisation approach
    public static  boolean wcMatching(int n, int m, String x, String y)
    {
        boolean[] prev = new boolean[m+1];
        boolean[] curr = new boolean[m+1];
        
        prev[0] = true;
        
        for(int j = 1; j<=m; j++)
            prev[j] = false;
        
      
       
       
        //filling dp table
        for(int i = 1; i<=n; i++)
        {
            //for every row there will be a updated 0th j column
            boolean flag = true;
            for(int l = 1; l<=i; l++)
            {
                if(x.charAt(l-1) != '*')
                {
                    flag = false;
                    break;
                }
            }
            
            curr[0] = flag;
        
            for(int j = 1; j<=m; j++)
            {
                //exploring all the possibilities
                if((x.charAt(i-1) == y.charAt(j-1))  || (x.charAt(i-1) == '?'))
                {
                    curr[j]  = prev[j-1];
                   
                }        
                //unmatch case
                else if(x.charAt(i-1) == '*')
                {
                    curr[j]  = curr[j-1] || prev[j];
                }

                else curr[j] = false;
             } 
            
            //after computing the row will exchange the references
            boolean[] temp = prev;
            prev = curr;
            curr  = temp;
        }
        
        
        return prev[m];
    }
}