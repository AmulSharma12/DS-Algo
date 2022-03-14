import java.util.Scanner;


public class Dp23_UnboundedKnapsack
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wt = new int[n];
		int[] val = new int[n];

		int W = sc.nextInt();

		System.out.println(maxProfit(n-1, W, wt, val));
	}


	//recursion + memoisation
	public static int maxProfit(int ind, int W, int[] wt, int[] val)
	{
		//base case


		//exploring all the stuff on tha index
		int notTake = 0 + maxProfit(ind-1, W,  wt, val);
		int take = Integer.MIN_VALUE;
		if(wt[ind] <= W)
			take = 1 + maxProfit(ind-1, W-wt[ind], wt, val);

		return Math.max(take,notTake); 
	}
}