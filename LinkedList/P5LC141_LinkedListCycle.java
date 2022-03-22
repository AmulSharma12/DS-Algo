// LeetCode 141
// LinkedList Cycle 
// https://leetcode.com/problems/linked-list-cycle/


public  class P5LC141_LinkedListCycle
{
	public static void main(String[] args)
	{
		// function call 
	}



	// LeetCode 141 solution
	public static  boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        //using fast and slow pointer we can get
        ListNode slow = head;
        ListNode fast = head;
 
        
        while(fast != null &&  fast.next != null)
        {
           fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                return true;
        }
        
        
        //as one of the becomes null
        return false;
    }
}