// https://leetcode.com/problems/spiral-matrix-ii/
// LeetCode 59 medium Spiral Matrix 2

import java.util.Scanner;
import java.util.Arrays;

public class Day13_LC59SpiralMatrix2
{
	public static void main(String[] args)
	{
		//generateMatrix(arr);
	}


	// LeetCode 59 Solution SpiralMatrix2
	public static int[][] generateMatrix(int n) {
        int num = 1;
        if(n == 1)
            return new int[][] {{1}};
        
        int[][] result = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        
        while(top <= bottom && left <= right)
        {
            //for top for every col
            for(int col = left; col<=right; col++)    
            {
                result[top][col] = num;
                num++;
            }
            
            top++;
            
            for(int row = top; row<=bottom; row++)
            {
                result[row][right] = num;
                num++;
            }
            
            right--;
            
            for(int col = right; col>=left; col--)
            {
                result[bottom][col] = num;
                num++;
            }
            
            bottom--;
            
            for(int row = bottom; row >= top; row--)
            {
                result[row][left] = num;
                num++;
            }
            
            left++;
        }
        
        return result;
    }
}