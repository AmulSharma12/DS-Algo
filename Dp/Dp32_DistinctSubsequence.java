// LeetCode 115
// https://leetcode.com/problems/distinct-subsequences/

import java.util.Scanner;
import java.util.Arrays;

public class Dp32_DistinctSubsequence
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(numDistinct(s1, s2));
	}



	 //recursive + memoisation way
    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
         // int[][] dp = new int[n+1][m+1];
        // for(int[] element : dp)
        // {
        //     Arrays.fill(element, -1);
        // }
        
        // return distinctT(n, m, s, t, dp);
         return distinct1A(n, m, s, t);
    }
    
    
    public static int distinct(int i, int j, String x, String y, int[][] dp)
    {
        if(j == 0) 
            return 1;
        if(i == 0)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // explore all the possibilities
        if(x.charAt(i-1) == y.charAt(j-1))
            return dp[i][j] = distinct(i-1, j-1, x, y,dp) + distinct(i-1, j, x, y, dp);
        
        return dp[i][j] = distinct(i-1, j, x, y, dp);
    }

    // tabulation way of finding distinct subsequene
    public static int distinctT(int n, int m, String x, String y, int[][] dp)
    {
    	for(int i = 0; i<=n; i++)
    	{
    		dp[i][0] = 1;
    	}



    	//explore all the stuff at that index
    	for(int i = 1; i<=n; i++)
    	{
    		for(int j = 1; j<=m;j++)
    		{
    			if(x.charAt(i-1) == y.charAt(j-1))
            		dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        
		        else 
		         dp[i][j] = dp[i-1][j];
    		}
    	}


    	return dp[n][m];
    }

    // 2 Array optimisation
   // 2 Array optimisation
     public  static int distinct2A(int n, int m, String x, String y)
    {
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        
         prev[0] = curr[0] = 1;
         
        //explore all the stuff at that index
        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                curr[j] = prev[j];
                if(x.charAt(i-1) == y.charAt(j-1))
                {
                    curr[j] += prev[j-1]; 
                }
                    
              
            }
            
             for(int j = 0; j<=m; j++)
                 prev[j] = curr[j];
             // int[] temp = prev;
             // prev = curr;
             // curr = temp;
            // prev = curr;

            
        }


        return prev[m];
         
     }



      // 1 Array optimisation
     public static int distinct1A(int n, int m, String x, String y)
    {
        int[] curr = new int[m+1];
        curr[0] = 1;
        
         for(int i = 1; i<=n; i++)
         {
             for(int j = m; j>=1; j--)
             {
                
                     if(x.charAt(i-1) == y.charAt(j-1))
                         curr[j] = curr[j] + curr[j-1];
                    
             }
         }
         
         return curr[m];
    }
}