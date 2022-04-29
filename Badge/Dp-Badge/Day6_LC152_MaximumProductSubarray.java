import java.util.Scanner;
import java.util.Arrays;

public class Day6_LC152_MaximumProductSubarray
{
	public static void main(String[] args)
	{	
		//function_call();
	}


	//LC 152 solution 
	 public static int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        
        
        for(int i = 0; i<n; i++)
        {
            int product = 1;
            for(int j = i; j<n; j++)
            {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        
        
        //return the answer
        return maxProduct;
    }
}