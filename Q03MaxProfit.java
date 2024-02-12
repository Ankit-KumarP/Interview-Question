// (17/01/2023, 7:53AM) | TradeDesk
// QUES: 
// INPUT
// rate: {2,4,1,5,10,6} , stratgy: {-1,1,0,1,-1,0}, k = 4, (-1: buy, 1:sell, 0: nothing)
// OUTPUT: 18
// EXPLANATION
// current profit is: (4+5) - (2+10) = -3
// set stratgy = {-1,1,0,0,1,1} then profit is => (4+10+6) - (2) = 18 
package My_Interview_Ques;

import java.util.*;
import java.lang.*;

public class Q03MaxProfit {

    // profit
    public static int profit(int[] rate, int[] staratgy, int k) {

        int index[] = new int[2];
        maximum(rate, k / 2, index);

        for (int i = index[0]; i <= index[1]; i++) {
            staratgy[i] = 1;
        }

        int ptr1 = index[0] - 1;
        int size = k / 2;
        while (size > 0) {
            staratgy[ptr1] = 0;
            ptr1--;
            size--;
        }

        int profit = 0;
        for (int i = 0; i < rate.length; i++) {
            if (staratgy[i] == -1) {
                profit -= rate[i];
            } else if (staratgy[i] == 1) {
                profit += rate[i];
            }
        }

        return profit;
    }

    // maximum : (finnding maximum sum of continious array of length k)
    static void maximum(int[] rates, int k, int index[]) {

        int n = rates.length, cSum = 0, maxSum = 0;
        int from = 0, to = 0;
        int ptr1 = k, ptr2 = k;

        while (ptr2 < n) {
            if ((ptr2 - ptr1) < k) {
                cSum += rates[ptr2];
                maxSum = cSum;
                from = ptr1;
                to = ptr2;
            } else {
                cSum = (cSum + rates[ptr2]) - rates[ptr1];
                ptr1++;
                if (cSum > maxSum) {
                    cSum = maxSum;
                    from = ptr1;
                    to = ptr2;
                }
            }

            ptr2++;
        }

        index[0] = from;
        index[1] = to;
    }

    public static void main(String args[]) {

        int[] rate = { 2, 4, 1, 5, 10, 6 };
        int[] stratgy = { -1, 1, 0, 1, -1, 0 };
        int k = 4;

        int ans = profit(rate, stratgy, k);
        System.out.println(ans);

    }
}
