// (03/02/2024, 7.55AM) | WayFair base question not original
// Given an array arr[] of N integers, the task is to find the count of all the subsets which do not contain adjacent elements from the given array.
// Examples:  

// Input: arr[] = {2, 7} 
// Output: 3 
// All possible subsets are {}, {2} and {7}.

// Input: arr[] = {3, 5, 7} 
// Output: 5  
package My_Interview_Ques;

import java.util.*;
import java.lang.*;

public class Q04DP {
    // function
    public static int totalNumber(String s) {

        int rtn = 0;
        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        rtn = total(s, "", 0, dp);

        return rtn;

    }

    // function
    public static int total(String str, String s, int ptr, int[] dp) {

        if (ptr >= str.length()) {
            return 1;
        }

        if (dp[ptr] != -1) {
            return dp[ptr];
        }

        // take
        int first = total(str, s + str.charAt(ptr), ptr + 2, dp);

        // not take
        int second = total(str, s, ptr + 1, dp);

        dp[ptr] = first + second;
        return dp[ptr];
    }

    public static void main(String[] args) {
        // String s = "357"; // 5
        // String s = "357890"; // 21
        String s = "3578909933"; // 144
        // String s = "0"; // 2

        int ans = totalNumber(s);
        System.out.println(ans);
    }
}
