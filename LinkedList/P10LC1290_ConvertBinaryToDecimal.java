// LeetCode 1290 Easy
// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

import java.util.Scanner;
import java.util.Arrays;

public class P10LC1290_ConvertBinaryToDecimal
{
	public static void main(String[] args)
	{
		//function call
	}


	//LeetCode 1290 solution convert binaryNumber in a LinkedList to a DecimalNumber
	public static  int getDecimalValue(ListNode head)
	 {
        ListNode temp = head;
        
        int ans = 0;
        // Approach 2  by reversing the linkedlist
        // Approach 3 using last node concept if it is not last node will accumulate the extra 2 to main ans and normal addition to ans will normally happen
        
        while(temp != null)
        {
            ans *= 2;
            ans += temp.val;   // this is nothing but temp.val * 2^0 which is nothing but 1 
            temp = temp.next;
        }
        
        return ans;
        
    }

}