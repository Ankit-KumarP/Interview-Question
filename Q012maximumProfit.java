// (02/04/2024, 11:13 AM)
// you are given two arrays A and B of size N.in the following operations can be
// performed on A choose at most two indexes i and j from a such that Aj+Aj <_ K
// it also given that from the selected index i you obtain a profit B find the
// maximum profit that can be obtained.
// int[] A1 = {1, 3, 4, 6, 8};
// int[] B1 = {2, 5, 3, 7, 9};
// int K1 = 10;
// System.out.println(maxProfit(A1, B1, K1)); // Output: 12
package My_Interview_Ques;

import java.util.*;
import java.lang.*;

public class Q012maximumProfit {

    // maxProfit
    static int maxProfit(int[] a, int[] b, int k) {

        int n = a.length;

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        int profit = helper(a, b, 0, n - 1, k, dp);

        return profit;

    }

    // helper
    static int helper(int[] a, int[] b, int i, int j, int k, int[][] dp) {

        if (i > j)
            return 0;
        else if (dp[i][j] != -1) {
            return dp[i][j];
        } else if (i == j && a[i] <= k) {
            int value = b[i];
            dp[i][j] = Math.max(value, Math.max(helper(a, b, i + 1, j, k, dp), helper(a, b, i, j - 1, k, dp)));
            return dp[i][j];
        } else if (a[i] + a[j] > k) {
            dp[i][j] = Math.max(helper(a, b, i + 1, j, k, dp), helper(a, b, i, j - 1, k, dp));
            return dp[i][j];
        } else {
            int value = b[i] + b[j];
            dp[i][j] = Math.max(value, Math.max(helper(a, b, i + 1, j, k, dp), helper(a, b, i, j - 1, k, dp)));
            return dp[i][j];
        }

    }

    public static void main(String[] args) {

        int[] A1 = { 1, 3, 4, 6, 8 };
        int[] B1 = { 2, 5, 3, 7, 9 };
        int K1 = 10;
        System.out.println(maxProfit(A1, B1, K1)); // Output: 12

        int[] A2 = { 2, 4, 5 };
        int[] B2 = { 1, 3, 7 };
        int K2 = 6;
        System.out.println(maxProfit(A2, B2, K2)); // Output: 7

        int[] A3 = { 3, 6, 8 };
        int[] B3 = { 2, 5, 7 };
        int K3 = 9;
        System.out.println(maxProfit(A3, B3, K3)); // Output: 7

        int[] A4 = { 1, 2, 3 };
        int[] B4 = { 2, 3, 4 };
        int K4 = 4;
        System.out.println(maxProfit(A4, B4, K4)); // Output: 6

        int[] A5 = { 1, 2, 3 };
        int[] B5 = { 2, 3, 4 };
        int K5 = 5;
        System.out.println(maxProfit(A5, B5, K5)); // Output: 7

        int[] A6 = { 5, 2, 11, 7, 13 };
        int[] B6 = { 6, 3, 12, 9, 15 };
        int K6 = 20;
        System.out.println(maxProfit(A6, B6, K6)); // Output: 24

        int[] A7 = { 6, 6, 6, 6, 6 };
        int[] B7 = { 1, 2, 10, 2, 4 };
        int K7 = 12;
        System.out.println(maxProfit(A7, B7, K7)); // Output: 14

    }
}