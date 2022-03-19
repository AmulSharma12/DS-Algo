//LeetCode 44
// https://leetcode.com/problems/wildcard-matching/submissions/

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Dp34_WildCardMatching
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(isMatch(s1, s2));

	}

	//p should contains two illegal characters
	public static boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        return wcMatching(n-1, m-1, p, s);
    }
    
    
    public static boolean wcMatching(int i, int j, String x, String y)
    {
        
        if(i<0 && j<0)
            return true;
        if(i<0 && j>=0)
            return false;
        if(j<0 && i>=0)
        {
            for(int l = 0; l<=i; l++)
            {
                char ch = x.charAt(l);
                if(ch != '*')
                    return false;
            }
            
            return true;
        }
        
        
        //exploring all the possibilities
        if((x.charAt(i) == y.charAt(j))  || (x.charAt(i) == '?'))
            return wcMatching(i-1, j-1, x, y);
        
        //unmatch case
        if(x.charAt(i) == '*')
            return  (wcMatching(i-1, j, x, y) || wcMatching(i, j-1, x, y));
        
        return false;
    }
}