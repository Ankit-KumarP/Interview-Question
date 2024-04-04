package My_Interview_Ques;

import java.util.*;
import java.lang.*;

public class Q07ResourceDistrubtion {

    public static int OneBlock(int N, int arr[]) {

        int max = 0, current = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                current++;
            } else
                current = 0;
            max = Math.max(max, current);
        }

        return max;
    }

    public static void main(String[] args) {

        // int N = 3;
        // int[] arr = { 0, 1, 0 };

        int N = 5;
        int[] arr = { 0, 1, 1, 0, 1 };
        int ans = OneBlock(N, arr);
        System.out.println(ans);
    }
}
