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


    
    
}