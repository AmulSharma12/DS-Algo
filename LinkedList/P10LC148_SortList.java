// LeetCode 148 Medium
// https://leetcode.com/problems/sort-list/

import java.util.Scanner;

public class P10LC148_SortList
{
	public static void main(String[] args)
	{
		// function call
	}


	// LeetCode 148 solution -> sort list
	 public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head; // Here we are checking for single or null values
        
        ListNode temp=head; //creating a temp to keep track of slow pointer
        ListNode slow=head; //creating a slow to keep track of mid position
        ListNode fast=head; //it will reach to null when slow reach across mid point 
        while(fast!=null && fast.next!=null){
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        temp.next=null;     //making the .next null so further list won't be considered
        ListNode sort_head=sortList(head); //to sord head part
        ListNode sort_tail=sortList(slow); //to sort tail part
        
        return mergeSort(sort_head,sort_tail); // it will return sorted list after comparison and merge   
    }
    
    public static ListNode mergeSort(ListNode head,ListNode tail){
        ListNode sorted=new ListNode(0);
        ListNode curr=sorted;
        while(head!=null && tail!=null){  // Here we are doing comparison and pushing in the curr list
            if(head.val<tail.val){
                curr.next=head;
                head=head.next;
            }else{
                curr.next=tail;
                tail=tail.next;
            }
            curr=curr.next;
        }
        if(head!=null){ // to fill remaining values of head
            curr.next=head;
        }
        if(tail!=null){ // to fill remaining values of tail
            curr.next=tail;
        }
        return sorted.next;
    }
}