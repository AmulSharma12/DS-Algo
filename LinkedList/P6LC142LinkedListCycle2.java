// LeetCode 142
// 


import java.util.Scanner;
import java.util.Arrays;

public class P6LC142LinkedListCycle2
{
	public static void main(String[] args)
	{
		//function call
	}



	// LeetCode 142 solution -> LinkedListCycle2
	 public static  ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        
        // finding the length of the cycle
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
                
                ListNode temp = slow;
                
                do{
                    temp = temp.next;
                    length++;
                }while(temp != slow);
                
                break;
            }
        }
        
        if(length == 0)
            return null;
        
        // finding out the start 
        ListNode f = head;
        ListNode s = head;
        
        while(length > 0)
        {
            s = s.next;
            length--;
        }
        
        
        
        //check where it will meet
        while(f != s)
        {
            f = f.next;
            s = s.next;
        }
        
        
        //return any of the node because both of the point out to the same node
        return f;   //return s;       
        
    }
}