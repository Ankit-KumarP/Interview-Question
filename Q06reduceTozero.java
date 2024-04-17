// (08/03/2024, 12:21) | Unstop
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

public class Q06reduceTozero {

    // Logic:
    // (I) If 'n' is even: It's smallest prime factor is '2'. And when we subtract
    // '2' from an even number is again become an even number. so answer is (n/2);
    // (II) If 'n' is odd: It's smallest prime factor is odd. And when we subrtract
    // odd from and odd it become an even number. so answer is ((n-d)/2) + 1 here
    // 'd' is smallest prime factor of 'n'.
    // T = O(n) | S = O(1)
    // count
    public static int count(int n) {

        int result = 0;
        if (n % 2 == 0) {
            return (n / 2);
        }
        int ptr = 2;
        while (n % ptr != 0)
            ptr++;
        result = 1 + ((n - ptr) / 2);

        return result;
    }

    public static void main(String[] args) {
        // int n = 9999; // 4999
        // int n = 2; // 1
        // int n = 25; //11
        int n = 50; // 25
        int ans = count(n);
        System.out.println(ans);

    }

}
