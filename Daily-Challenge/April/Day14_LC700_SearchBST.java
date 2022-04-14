// https://leetcode.com/problems/search-in-a-binary-search-tree/
// LeetCode 700 medium search binary search tree

import java.util.Scanner;
import java.util.Arrays;


class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class Day14_LC700_SearchBST
{
	public static void main(String[] args)
	{
		//function call 
		searchBST(root, val);
	}


	// LeetCode 700 SerachBST Solution
	  //Approach 1- using recursion -> return the node whose value is equal to the node value
    public TreeNode searchBST(TreeNode root, int val) {
       if(root == null || root.val == val)
           return root;
        
        if(root.val > val)
            return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

}