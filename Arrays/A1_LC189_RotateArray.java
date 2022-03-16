import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class A1_LC189_RotateArray
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i<n; i++)
		{
			arr[i] = sc.nextInt();
		}

		int k = sc.nextInt();
		rotate(arr, k);
		// rotateO(arr, k);
		System.out.println(Arrays.toString(arr));
	}


	// -------------brute force solution o(N) time and o(N) space complexity
	 public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        if(k == 0)
            return;
        else
        {
            List<Integer> ds = new ArrayList<>();
            
           //storing the element which can comes to front
            for(int i = n-k ; i<n; i++)
                ds.add(nums[i]);
            
            //rotate to k indexes
            for(int i = n-k-1; i>=0; i--)
                nums[i+k] = nums[i];
           
            
            //update the front element using ds 
            for(int i = 0; i<k; i++)
                nums[i] = ds.get(i);
        }
         
    }


    //------------------optimised o(n) and o(1) space
    public static  void rotateO(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        if(k == 0)
            return;
        else
        {
            // Trick to get rotated array
            //reverse each part seprately
            reverse(nums, 0, n-k-1);
            reverse(nums, n-k, n-1);
            
            //reverse entire array
            reverse(nums, 0, n-1);
        }
         
    }
    
    
    public static void reverse(int[] nums, int low, int high)
    {
        while(low < high)
        {
            swap(nums, low, high);
            low++;
            high--;
        }
    }
    
    public  static void swap(int[] nums, int low, int high)
    {
        nums[low] = nums[low] ^ nums[high];
        nums[high] = nums[low] ^ nums[high];
        nums[low] = nums[low] ^ nums[high];
    }
}