// https://leetcode.com/problems/baseball-game
// LeetCode 682 easy BaseBall Game
import java.util.List;
import java.util.ArrayList;
public class Day10_LC682BaseBallGame
{
	public static void main(String[] args)
	{
		System.out.println(calPoints(new String[]{"5", "2", "C", "D" , "+"}));
	}

	//LeetCode 682 Solution 
	 //Approach 1 - Using Optimised TC : o(N) || SC : O(N)
    public static int calPoints(String[] ops) {
        int n = ops.length;
        List<Integer> recordList = new ArrayList<>();
        
        for(String element : ops)
        {
            int value  = 0;
            
            if(element.equals("C"))
            {
                //eliminate the last record only and not to do anything 
                recordList.remove(recordList.size() - 1);
                continue;
                
            }
            else if(element.equals("D"))
            {
                value = 2 *  recordList.get(recordList.size() -1);
                
            }
            
            else if(element.equals("+"))
            {
                value = recordList.get(recordList.size() -1) + recordList.get(recordList.size() -2);
            }
            else 
            {
                value  = Integer.parseInt(element);
            }
            
            
            recordList.add(value);
        }
        
        
        //accumulating the sum
        int sumOfAllRecords = 0;
        int size = recordList.size();
        for(int i = 0; i<size; i++)
            sumOfAllRecords += recordList.get(i);
            
        
        return sumOfAllRecords;
    }
}