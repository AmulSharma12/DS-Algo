// https://leetcode.com/problems/design-hashmap/
// LeetCode 706 Design HashMap

import java.util.Scanner;
import java.util.Arrays;

public class Day22_LC706_DesignHashMap
{
	public static void main(String[] args)
	{
		//function_call();
	}
}


//LeetCode 706 Easy Design HashMap solution
class MyHashMap {
    private int[] map;
    private int size;
    
    public MyHashMap() {
        this.size = 1000000;
        map = new int[size+1];
        Arrays.fill(map , -1);
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */