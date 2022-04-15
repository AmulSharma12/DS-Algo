// https://leetcode.com/problems/trim-a-binary-search-tree/
// LeetCode 669 Medium solution Trim BinarySearch Tree( Trim BST)

import java.util.Scanner;
import java.util.Arrays;

public class Day15_LC669_TrimBST
{
	public static void main(String[] args)
	{
		// function call
	}


	//LeetCode 669 Medium Solution TrimBST
	public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)    return root;
        if(root.val < low)  return trimBST(root.right, low, high);
        if(root.val > high) return trimBST(root.left, low, high);
        
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}