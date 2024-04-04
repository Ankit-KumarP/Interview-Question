// (08/03/2024, 12:21)
// Given an integer n. The task is to count the number of operations required to reduce n to 0. In every operation, n can be updated as n = n – d where d is the smallest prime divisor of n.
// Examples: 
// Input: n = 5 
// Output: 1 
// 5 is the smallest prime divisor, thus it gets subtracted and n gets reduced to 0.
// Input: n = 25 
// Output: 11 
// 5 is the smallest prime divisor, thus it gets subtracted and n gets reduced to 20. Then 2 is the smallest divisor and so on.
// Input: n = 4 
// Output: 2 
package My_Interview_Ques;

import java.util.*;
import java.lang.*;

public class Q011reduceTozero {

    // count
    public static int count(int n) {

        int result = 0;
        if (n == 0)
            return 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                result = 1 + count(n - i);
                break;
            }
        }

        return result ;
    }

    public static void main(String[] args) {
        int n = 9999; //4999
        // int n = 2; // 1
        // int n = 8;
        // int n = 25;
        // int n = 7;
        // int n = 50 //25
        int ans = count(n);
        System.out.println(ans);

    }

}
