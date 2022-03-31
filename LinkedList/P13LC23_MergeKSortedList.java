// LeetCode 23 Hard Merge K sorted list
// 

import java.util.Scanner;

public class P13LC23_MergeKSortedList
{
	public static void main(String[] args)
	{
		//function call
	}

	//LeetCode 23 Solution
	public static ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        int currIndex = 0;
        ListNode mergeList = null;
        
        while(currIndex < size)
        {
            mergeList = merge(mergeList , lists[currIndex]);
            currIndex++;
        }
        
        return mergeList;
    }
    
    
    //merge function for 2 sorted lists
    public static ListNode merge(ListNode l1 , ListNode l2)
    {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }
            else
            {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
                
        }
        
        
        //the remaining list merge
        if(l1 != null)
            temp.next = l1;
        else
            temp.next = l2;
        
        return dummy.next;
    }
}