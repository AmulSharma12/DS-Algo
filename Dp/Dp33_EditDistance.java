import java.util.Scanner;
import java.util.Arrays;

public class Dp33_EditDistance
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int result = minDistance(s1, s2);
		System.out.println(result);
	}


	 public static int minDistance(String word1, String word2) {
       int n = word1.length();
       int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        
        // for(int[] element : dp)
        // {
        //     Arrays.fill(element, -1);
        // }
        return minOperationsT(n, m, word1, word2, dp);
        
    }
    
    
    public static int minOperations(int i, int j, String x, String y, int[][] dp)
    {
        //if string 1 exhausted then remaining of s2 will be no of insertion have to perform in s1
        if(i == 0)
            return j;
        
        //same but no of deletion in s1
        if(j == 0)
            return i;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(x.charAt(i-1) == y.charAt(j-1))
            return dp[i][j] = 0 + minOperations(i-1, j-1, x, y, dp);
        
        //now in no match 3 operations can be performed
        int ins = 1 + minOperations(i, j-1, x, y, dp);
        int del = 1 + minOperations(i-1, j, x, y, dp);
        int replace = 1 + minOperations(i-1, j-1, x, y, dp);
        
        return dp[i][j] =  Math.min(ins, Math.min( del, replace));
    }


    //tabulation approach
    public static int minOperationsT(int n, int m, String x, String y, int[][] dp)
    {
       //for i == 0 every j [0...m] is j only
        for(int j = 0; j<=m; j++)
            dp[0][j] = j;
        
        //for every j == 0   every i[0...n]  is i only
        for(int i = 0; i<=n; i++)
            dp[i][0] = i;
        
        
        //explore all the possibilities now
        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                if(x.charAt(i-1) == y.charAt(j-1))
                    dp[i][j] =  0 + dp[i-1][j-1];
                else
                    dp[i][j] = 1 +  Math.min(dp[i][j-1] , Math.min(dp[i-1][j] , dp[i-1][j-1]));
            }
        }
        
        
        return dp[n][m];
    }

    //2Array space optimisation 
    public static int minOperationsT(int n, int m, String x, String y)
    {
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        
       //for i == 0 every j [0...m] is j only
        for(int j = 0; j<=m; j++)
            prev[j] = j;
        
        
        
        //explore all the possibilities now
        for(int i = 1; i<=n; i++)
        {
            curr[0] = i;
            for(int j = 1; j<=m; j++)
            {
                if(x.charAt(i-1) == y.charAt(j-1))
                    curr[j] =  0 + prev[j-1];
                else
                    curr[j] = 1 +  Math.min(curr[j-1] , Math.min(prev[j] , prev[j-1]));
            }
            
            //switching the referecnce
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        
        return prev[m];
    }
}