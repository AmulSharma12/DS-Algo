import java.util.*;

public class Solution
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 1, 4, 1};
		int ans = getTotal(arr);
		System.out.println(ans);
	}



	public static int getTotal(int[] arr)
	{
		int n = arr.length;
		int ans = 0;
		int min = Integer.MAX_VALUE;

		for(int i = 0; i<n; i++)
			min = Math.min(min, arr[i]);

		for(int i = 0; i<n; i++)
		{
			List<Integer> ds = new ArrayList<>();
			int minCount = 0;

			for(int j = i; j<n; j++)
			{
				if(arr[j] == min)
						minCount++;
				if(minCount > 1)
						break;

					ds.add(arr[j]);
					

					if(ds.contains(min))
					{
						System.out.println(ds);
						ans++;
					}
					
			}

			
			
		}

		return ans;
	}
}



