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


    //Approach 2 - Using Optimal technique -> O(n)
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        
        for(int i = 1; i<n; i++)
        {
            
            if(nums[i] < 0)
            {
                //swap out the max and min variable
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i] , nums[i]*max);
            min = Math.min(nums[i] , nums[i]*min);
            ans = Math.max(ans, max);
        }
        
        
        return ans;
    }

    
}