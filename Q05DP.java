// (03/02/2024, 7.55AM) | WayFair 
// / QUESTION
// Problem Statement
// You are given a string s of length n. You want to find all the distinct non-empty strings that can be formed from s such that:
// No two adjacent characters from the string s are chosen in the string that we make from s.
// Since the answer can be large print it modulo 10^9+7.

// Input Format
// The only line of input contains a string s.
// Constraints

// 1 <= n <= 10^5
// Output Format

// Return an integer as asked.
// Evaluation Parameters

// Sample Input
// dd
// Sample Output
// 1
package Interview_Ques;

import java.util.*;
import java.lang.*;

public class Q05DP {

    // function
    public static int totalSubsets(String s) {

        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        String sb = new String(arr);
        List<String> list = new ArrayList<>();
        helper(sb, "", 0, list);
        System.out.println(list);
        return list.size();

    }

    // function
    public static void helper(String str, String s, int ptr, List<String> list) {

        if (ptr >= str.length()) {
            if (!list.contains(s) && !s.equals("")) {
                list.add(s);
            }
            return;
        }

        // include
        helper(str, s + str.charAt(ptr), ptr + 2, list);

        // exclude
        helper(str, s, ptr + 1, list);

    }

    public static void main(String[] args) {
        // String s = "357890"; // 20
        // String s = "def"; // 4
        // String s = "dd"; //1
        String s = "3578909933"; //

        int ans = totalSubsets(s);
        System.out.println(ans);
    }

}
