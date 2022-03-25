// LeetCode 206
// https://leetcode.com/problems/reverse-linked-list/submissions/

public class P10LC206_ReverseLinkedList
{
	public static void main(String[] args)
	{

	}


	//LeetCode 206 solution 
	 public  static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;
        
        while(pres != null)
        {
            pres.next = prev;
            prev = pres;
            pres = next;
           if(next != null) next = next.next;
        }
        
        head = prev;
        return head;
        
    }
}