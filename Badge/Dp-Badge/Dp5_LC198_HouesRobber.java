// https://leetcode.com/problems/house-robber/
// LeetCode 198 Medium HouseRobber

public class Dp5_LC189_HouseRobber
{
	public static  void main(String[] args)
	{
		int maxProfit = rob(new int[] {});
		System.out.println(maxProfit);
	}

	//--------------------------------- Approach 1 -using recursive
    public static int rob(int[] nums) {
        int n = nums.length;
        
        return robHouse(n-1, nums);
    }
    
    //function robHouse -> return the maximum amount of money robbed till n-1 (Last) house
    public static int robHouse(int ind, int[] nums)  //each house represent by index ind
    {
        if(ind < 0)
            return 0;
        if(ind == 0)
            return nums[ind];
        
        
        // rob all the houses
        int rob = nums[ind] + robHouse(ind-2, nums);
        int notRob = 0 + robHouse(ind-1, nums);
        
        return Math.max(rob, notRob);
        
    }


     //----------------------------------------- Approach 2 -using Memoization
    public static int robM(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return robHouseM(n-1, nums, dp);
    }
    
    //function robHouse -> return the maximum amount of money robbed till n-1 (Last) house
    public int robHouseM(int ind, int[] nums, int[] dp)  //each house represent by index ind
    {
        if(ind < 0)
            return 0;
        if(ind == 0)
            return nums[ind];
        if(dp[ind] != -1)
            return dp[ind];
        
        // rob all the houses
        int rob = nums[ind] + robHouse(ind-2, nums, dp);
        int notRob = 0 + robHouse(ind-1, nums, dp);
        
        return dp[ind] = Math.max(rob, notRob);
        
    }


     // ------------------------------------------ Approach 3 -using Tabulation
    public static  int robT(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        return robHouse(nums, dp, n);
    }
    
    //function robHouse -> return the maximum amount of money robbed till n-1 (Last) house
    public static int robHouseT(int[] nums, int[] dp, int n)  //each house represent by index ind
    {
       dp[0] = 0;
       dp[1] = nums[0];

        for(int ind = 2; ind <=n; ind++)
        {
                 // rob all the houses
                int rob = nums[ind-1] + dp[ind-2];
                int notRob = 0 + dp[ind-1];
            
                 dp[ind] = Math.max(rob, notRob);
        }
       
        return dp[n];
    }


     // ------------------------------------------- Approach 4 -using Space Optimisation
    public static int rob(int[] nums) {
        int n = nums.length;
        return robHouse(nums, n);
    }
    
    //function robHouse -> return the maximum amount of money robbed till n-1 (Last) house
    public static int robHouse(int[] nums,  int n)  //each house represent by index ind
    {
       int prev2 = 0;
       int prev = nums[0];

        for(int ind = 2; ind <=n; ind++)
        {
                 // rob all the houses
                int rob = nums[ind-1] + prev2;
                int notRob = 0 + prev;
            
                 int curr = Math.max(rob, notRob);
                 prev2 = prev;
                 prev = curr;
        }
       
        return prev;
    }

}