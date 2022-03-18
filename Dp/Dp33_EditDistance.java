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


	 public static  int minDistance(String word1, String word2) {
       int n = word1.length();
       int m = word2.length();
        int[][] dp = new int[n][m];
        
        for(int[] element : dp)
        {
            Arrays.fill(element, -1);
        }
        return minOperations(n-1, m-1, word1, word2, dp);
        
    }
    
    
    public static  int minOperations(int i, int j, String x, String y, int[][] dp)
    {
        //if string 1 exhausted then remaining of s2 will be no of insertion have to perform in s1
        if(i<0)
            return j+1;
        
        //same but no of deletion in s1
        if(j<0)
            return i+1;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(x.charAt(i) == y.charAt(j))
            return dp[i][j] = 0 + minOperations(i-1, j-1, x, y, dp);
        
        //now in no match 3 operations can be performed
        int ins = 1 + minOperations(i, j-1, x, y, dp);
        int del = 1 + minOperations(i-1, j, x, y, dp);
        int replace = 1 + minOperations(i-1, j-1, x, y, dp);
        
        return dp[i][j] =  Math.min(ins, Math.min( del, replace));
    }
}