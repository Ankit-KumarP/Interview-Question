// (16/04/2024, 22:01)  Glider.AI
package My_Interview_Ques;

import java.util.*;
import java.lang.*;

public class Q07RunningAverage {

    // runningAverage
    static List<Float> runningAverage(int[] arr, int k) {

        int n = arr.length;
        List<Float> answer = new ArrayList<>();
        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
        }

        float first = (float) prefix[k - 1] / k;
        answer.add(first);
        int ptr = 0;
        for (int i = k; i < n; i++) {
            first = (float) (prefix[i] - prefix[ptr++]) / k;
            answer.add(first);

        }

        return answer;

    }

    public static void main(String[] args) {

        // int[] arr = { 2, 3, 4, 5, 1, 2, 3, 1, 3 };
        // int k = 5;   // [3.0, 3.0, 3.0, 2.4, 2.0]

        int [] arr = {1,1,1,1,2,1,1};
        int k = 3;

        List<Float> answer = runningAverage(arr, k);
        System.out.println(answer);

    }
}