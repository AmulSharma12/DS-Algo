// LeetCode 876
// https://leetcode.com/problems/middle-of-the-linked-list/

import java.util.Scanner;
import java.util.ArrayList;

public class P9LC876_MiddleOfLinkedList
{
	public static void main(String[] args)
	{
		// function call

	}



	// LeetCode 876 solution -> find the middle of linkedlist in two scan
	 public ListNode middleNode(ListNode head) {
        
        //first step will be to calculate the size of the linkedlist
        int size = sizeOfLL(head);
        
        // 2.) calculating the mid of the linkedlist
        int mid = size/2;
        System.out.println(size);
        
        ListNode temp = head;
        //traverse till that mid
        for(int i = 1; i<=mid; i++)
        {
            temp = temp.next;
        }
    
        
        return temp;
        
    }
    
    
    public int sizeOfLL(ListNode head)
    {
        int size = 0;
        
        ListNode temp = head;
        while(temp != null)
        {
            temp = temp.next;
            size++;
        }
        return size;
    }



    // optimised -> find the middle of the linkedlist in single scan
    public ListNode middleNode(ListNode head) {
        
        //by single scan of the linkedlist 
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        //as fast move twice so it reach faster when it reach slow is is middle somewhere as one moving single steps and one two steps
        // 1........dest    1.2.3.....dest     1..2..4..5..6  
        return slow;
        
    }
}