// LeetCode 92 Reverse LinkedList 2
// https://leetcode.com/problems/reverse-linked-list-ii/

public class P11LC92_ReverseLinkedList2
{
	public static void main(String[] args)
	{
		//function call
	}


	//LeetCode 92 solution
	public static ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        for(int i = 0; curr != null  && i<left-1; i++)
        {
            prev = curr;
            curr = curr.next;
        }
        
        ListNode last = prev;
        ListNode newEnd = curr;
        ListNode next = curr.next;
        
        //reverse between left and right
        for(int i = 0; curr != null && i<right-left+1; i++)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null)
                next = next.next;
        }
        
        
        if(last != null)
            last.next = prev;
        else
            head = prev;
        
        newEnd.next = curr;
        
        return head;
        
    }

}