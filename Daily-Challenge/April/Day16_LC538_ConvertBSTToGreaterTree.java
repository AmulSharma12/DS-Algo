// https://leetcode.com/problems/convert-bst-to-greater-tree/
// LeetCode Medium 538 Convert Bst TO Greater Tree

// Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
import java.util.Scanner;
import java.util.Arrays;

public class Day16_LC538_ConvertBSTToGreaterTree
{
	public static void main(String[] args)
	{
		//function_call()
	}


	 private int sum = 0;
    //--------------------------------- Approach 1 - Using recursive -> right root left l
    public TreeNode convertBST(TreeNode root) {
         if(root == null)   return root;
        
        convertBST(root.right);
        sum = sum + root.val;
        root.val = sum;
        convertBST(root.left);
        
        
        return root;
    }


    // ---------------------------- Approach 2 - Using Iterative -> (Stack)

   private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
         if(root == null)   return root;
         Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        
        while(!st.isEmpty() || node != null)
        {
            while(node != null)
            {
                st.add(node);
                node = node.right;
            }
            
            node = st.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
            
        }
        
        
        return root;
    }
}