// https://leetcode.com/problems/n-th-tribonacci-number/
// LeetCode 1137 Easy Tribbonaci Number
import java.util.Arrays;

public class Dp2_LC1137_Tribbonaci
{
	//Main Function
	public static void main(String[] args)
	{
		int tribbonaciNumber =  tribonacci(4);  // tribbonaci of 4 is 4
		System.out.println(tribbonaciNumber);
	}


	//------------------------------Tribbonaci Function
    public static int tribonacci(int n) {

    	//which type of method to call -> recursive , memoize , tabulation , space Optimisation
        return tribRec(n);
    }
    

    // ------------------------------- Approach 1- Using recursion
    public static  int tribRec(int n)
    {
        if(n == 0)
            return 0;
        
        if(n == 1 || n == 2)
            return 1;
        
        
        return tribRec(n-1) + tribRec(n-2) + tribRec(n-3);     
    }


     //------------------------------------ Approach 2- Using Memoization
    public static  int tribonacciM(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return tribMemoize(n, dp);
    }
    
    public static int tribMemoize(int n, int[] dp)
    {
        if(n == 0)
            return 0;
        
        if(n == 1 || n == 2)
            return 1;
        
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = tribMemoize(n-1, dp) + tribMemoize(n-2, dp) + tribMemoize(n-3, dp);     
    }


    // ---------------------------------------- Approach 3- Using Tabulation
    public static int tribonacciT(int n) {
        int[] dp = new int[n+1];
        return tribTabulation(n, dp);
    }
    
    public static  int tribTabulation(int n, int[] dp)
    {
        if(n == 0)
            return 0;
        
        if(n == 1 || n == 2)
            return 1;
        
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        
       for(int i = 3; i<=n; i++)
           dp[i] = dp[i-1]  + dp[i-2] + dp[i-3];
            
        //last state will have the n state which is being asked
        return dp[n];
    }


    //-------------------------------------------- Approach 4- Using Space Optimisation
    public static int tribonacciS(int n) {
        return tribSpaceOpt(n);
    }
    
    public static int tribSpaceOpt(int n)
    {
        if(n == 0)
            return 0;
        
        if(n == 1 || n == 2)
            return 1;
        
        int prev3 = 0;
        int prev2,prev;
        prev2 = prev = 1;
        
       for(int i = 3; i<=n; i++)
       {
           int ans = prev + prev2 + prev3;
           prev3 = prev2;
           prev2 = prev;
           prev = ans;
       }
            
        //last state will have the n state which is being asked
        return prev;
    }
}