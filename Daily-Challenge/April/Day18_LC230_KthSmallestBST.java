// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// LeetCode 230 Medium Kthsmallest element in a binarySearchTree

import java.util.Scanner;
import java.util.Arrays;

public class Day18_LC230_KthSmallestBST
{
	public static void main(String[] args)
	{
		//function_call();
	}


	//LeetCode 230 Medium Solution
	//Approach 2 - Using Stack for iteration
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        
        //now will go to leaft node
       while(true)
       {
            while(root != null)
            {
                st.push(root);
                root = root.left;
            }
           
           root = st.pop();
           k--;
           if(k == 0)
               return root.val;
           root = root.right;
       }
    }
}