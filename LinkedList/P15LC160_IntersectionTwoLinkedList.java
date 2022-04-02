// LeetCode 160 InterSection of two linkedlist return the node of intersection
// https://leetcode.com/problems/intersection-of-two-linked-lists/

import java.util.Scanner;

public class P15LC160_IntersectionTwoLinkedList
{
	public static void main(String[] args)
	{
		// function call
	}


	//LeetCode 160 Solution
	//Approach 1 - using simple traversing in both of the list
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA;
        
        
        while(ptr1 != null)
        {
                
            ListNode ptr2 = headB;
                    while(ptr2 != null)
                    {
                        //this is the intersection can happen so you can return any of them 
                        if(ptr1 == ptr2)
                            return ptr1;
                        ptr2 = ptr2.next;
                    }
            
            ptr1 = ptr1.next;
        }
        
        
        return null;
    }


    //Approach 2- by making pointers synchronise then it will meet at the intersecting points / null
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        
        while(ptr1 != ptr2)
        {
            if(ptr1 == null)
                ptr1 = headB;
            else
                ptr1 = ptr1.next;
            
            if(ptr2 == null)
                ptr2 = headA;
            else
                ptr2 = ptr2.next;
        }
        
        
        //return either of two pointers
        return ptr1;
    }
}
