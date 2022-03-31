// LeetCode 21
// https://leetcode.com/problems/merge-two-sorted-lists/

import java.util.Scanner;
import java.util.Arrays;

public class P4LC21_MergeTwoSortedList
{
	public static void main(String[] args)
	{

	}


	//LeetCode 21 solution
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2)
	{
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        //list1 is empty and list2 is not empty then ans will be list2
        if(list1 == null && list2 != null)
            return list2;
        
        //list2 is empty and list1 is not empty then ans will be the head of list1
        if(list2 == null && list1 != null )
            return list1;
        
        //if there is atleast one node in both of the linkedlist
        return mergeSortedList(list1, list2);
        
    }

     //Approach -2 using recursion
    public static  ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }
    
    
    public static  ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        if(l1.val < l2.val)
        {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = merge(l1, l2.next);
            return l2;
        }
        
    }
    
    
}