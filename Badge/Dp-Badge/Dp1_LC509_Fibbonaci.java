// https://leetcode.com/problems/fibonacci-number/
// LeetCode 509 Easy fibbonaci Number
import java.util.Arrays;

public class Dp1_LC509_Fibbonaci
{
	//main Function
	public static void main(String[] args)
	{
		System.out.println(fibbonaci(4)); //3
	}

	// -----------------------------fibbonaci function
	public static int fibbonaci(int n)
	{
		return fibTabulation(n);
	}


	//---------------------------Approach 1 - using recursion  
    public static  int fib(int n) {
        if(n == 0 || n == 1)
            return n;
        
        //function call it is the sum of previous two ones
        return fib(n-1) + fib(n-2);
    }


     //-----------------------------Approach 2 - using memoisation 
    public static int fibRecursive(int n) {
      int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fibRec(n, dp);
    }
    
    public static int fibRec(int n, int[] dp)
    {
        if(n == 0 || n == 1)
            return n;
        
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = fibRec(n-1, dp) + fibRec(n-2, dp);
    }



    //---------------------------------Approach 3 - Using Tabulation
    public static int fibTabulation(int n) {
        int[] dp = new int[n+1];
        return fibTab(n, dp);
    }
    
    public static int fibTab(int n, int[] dp)
    {
        if(n == 0 || n == 1)
            return n;
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i<=n; i++)
            dp[i]  = dp[i-1] + dp[i-2];
        
        return dp[n];
    }



    //Approach 4 - Using Space Optimisation 
    public static int fib(int n) {
        return fibSpaceOpt(n);
    }
    
    public static  int fibSpaceOpt(int n)
    {
        if(n == 0 || n == 1)
            return n;
        
        int prev2 = 0;
        int prev = 1;
        
        for(int i = 2; i<=n; i++)
        {
            int curr  = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
    }

}