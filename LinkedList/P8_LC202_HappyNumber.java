// LeetCode 202
// https://leetcode.com/problems/happy-number/

import java.util.Scanner;
import java.util.Arrays;

public class P8_LC202_HappyNumber
{
	public static void main(String[] args)
	{

	}



	// LeetCode 202 solution
	public static  boolean isHappy(int n) {
        
        //it will use cycle detection approach only as if we fall in loop then there is pattern value will repeat 
        int slow = n;
        int fast = n;
        
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);
        
        if(slow == 1)
            return true;
        
        
        return false;
        
    }
    
    
    
    //function finding the sum of squares of its digits
    public static int findSquare(int n)
    {
        int ans = 0;
        while(n > 0)
        {
            int rem = n % 10;
            ans += rem* rem;
            n /= 10;
            
        }
        
        
        return ans;
    }
}