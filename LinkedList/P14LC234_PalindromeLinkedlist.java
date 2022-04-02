// LeetCode 234 Easy Palindrome Linkedlist
// Check whether the linkedlist is palindrome or not
import java.util.Scanner;

public class P14LC234_PalindromeLinkedlist
{
	public static void main(String[] args)
	{
		//function call
	}

	//Approach 1 using string 
	 public static boolean isPalindrome(ListNode head) {
        //Approach 1 - using array/ strings
        
        StringBuilder sb = new StringBuilder();
        
        ListNode temp = head;
        while(temp != null)
        {
            sb.append(temp.val);
            temp = temp.next;
        }
        
        String result = sb.toString();
        
        int n = result.length();
        return isPalindrome(result, 0, n-1);
    }
    
    
    public static  boolean isPalindrome(String s, int i, int j)
    {
        while(i < j)
        {
            char first = s.charAt(i);
            char last = s.charAt(j);
            
            if(first != last)
                return false;
            i++;
            j--;
        }
        
        return true;
    }

}