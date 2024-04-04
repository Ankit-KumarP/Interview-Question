// (29/02/2024, 8:15am)
// QUES:
// Given a string S, the task is to find the lexicographically largest
// subsequence that can be formed using all distinct characters only once from
// the given string.
// Examples:
// Input: S = ababc
// Output: bac
// Explanation:
// All possible subsequences containing all the characters in S exactly once are
// {“abc”, “bac”}. The lexicographically maximum among all the subsequences is
// “bac”.
// Input: S = “zydsbacab”
// Output: zydscab
package My_Interview_Ques;

import java.util.*;
import java.lang.*;

public class Q010LexoLargest {
    static String lexicoMaxSubsequence(String s, int n) {

        StringBuilder sb = new StringBuilder();
        int frq[] = new int[26];
        for (char c : s.toCharArray()) {
            frq[c - 'a']++;
        }
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            frq[temp - 'a']--;
            if (s.isEmpty()) {
                st.push(temp);
            } else if (!st.contains(temp)) {
                while (!st.isEmpty() && !st.contains(temp) && temp > st.peek() && frq[st.peek() - 'a'] > 0) {
                    st.pop();
                }
                st.push(temp);

            }
        }

        while (!st.isEmpty())
            sb.append(st.pop());

        return sb.reverse().toString();

    }

    public static void main(String[] args) {

        // String s = "ababc"; // bac
        String s = "zydsbacab"; // zydscab
        String ans = lexicoMaxSubsequence(s, s.length());
        System.out.println(ans);

    }
}