// https://leetcode.com/problems/increasing-order-search-tree/
// LeetCode easy 897 Increasing Order Search Tree
import java.util.Scanner;
import java.util.Arrays;

public class Day17_LC897_IncreasingOrderSearchTree
{
	public static void main(String[] args)
	{
		// function_Call();
	}


	//LeetCode 897 Easy IncreasingOrderSearchTree
	// Approach 1 - Using Recursion
    public  static TreeNode increasingBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        inorder(root, ans);
        
        //now we will construct with the help of ans arraylist
        TreeNode dummy = new TreeNode(-1);
        TreeNode temp = dummy;
        int size = ans.size();
        int currInd = 0;
        
        while(currInd < size)
        {
            int value = ans.get(currInd);
            TreeNode node = new TreeNode(value);
            temp.right = node;
            temp = node;
            currInd++;
        }
        
        return dummy.right;
    }
    
    
    public static void inorder(TreeNode node, List<Integer> ds)
    {
        if(node == null)        return;
        
        inorder(node.left, ds);
        ds.add(node.val);
        inorder(node.right, ds);
    }




    
    // ------------------------------------------ Approach 2- Using Relinking while traversing
    private TreeNode curr;
    public static  TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        curr = dummy;
        inorder(root);
        
        return dummy.right;
    }
    
    
    public static void inorder(TreeNode node)
    {
        if(node == null)        return;
        
        inorder(node.left);
        node.left = null;
        curr.right = node;
        curr = node;
        inorder(node.right);
    }
}