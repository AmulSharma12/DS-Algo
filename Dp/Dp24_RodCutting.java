// rod cutting problem you will be give n and array n -> dentoes the length of the rod
import java.util.Scanner;


public class Dp24_RodCutting
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] price = new int[n];

		for(int i = 0; i<n; i++)
		{
			price[i] = sc.nextInt();
		}



		//what will be the maximum price that can have

		System.out.println(rodCutting(n-1, n, price));
	}



	//recursive + memoise solution -> dp of changing variable with their max value size 
	public static int rodCutting(int ind , int N, int[] price)
	{
		//at index 0 means rod of length 1 so how many rod needed to make N
		if(ind == 0)
		{
			return N * price[0];
		}


		//exploring all the index
		int notTake = 0 + rodCutting(ind-1, N, price);
		int rodLength = ind + 1;
		int take = Integer.MIN_VALUE;
		if(rodLength <= N)
			take = price[ind] + rodCutting(ind-1, N-rodLength, price);

		return Math.max(take, notTake);
	}
}