// LeetCode 83
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

import java.util.Scanner;
import java.util.Arrays;

public class P3_LC83_RemoveDuplicateSortedList
{
	public static void main(String[] args)
	{
		// function calling 
		deletedDuplicates(head);

	}


	// code solution LeetCode 83 function
	public ListNode deleteDuplicates(ListNode head) {
        
        //for empty linkedlist and single node 
        if(head == null || head.next == null)
            return head;
        
        //we check only if there next of temp exists
        ListNode temp = head;
        
        while(temp.next != null)
        {
            if(temp.val == temp.next.val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        
        return head;
    }
}