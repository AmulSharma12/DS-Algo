// LeetCode 82 Medium remove duplicates from sorted list 2
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
import java.util.Scanner;

public class P12LC82_RemoveDuplicateSortedList2
{
	public static void main(String[] args)
	{
		//function calll
	}

	// LeetCode 82 Medium function solution
	 public static ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = head;
        ListNode result = dummy;
        
        //adding to the dummy node 
        while(temp != null)
        {
            if(temp.next != null && temp.val == temp.next.val)
            {
               int value = temp.val;
                while(temp!= null && value == temp.val)
                    temp = temp.next;
                result.next = temp; 
            }
            else
            {
                ListNode node = new ListNode(temp.val);
                result.next = node;
                result = node;
                temp = temp.next;
            }
        }
        
        
        return dummy.next;
    }



}