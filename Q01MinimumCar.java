// // (12/01/2024, 16:42)  | Bentley Systems
// // QUES
// A group of friends is going on holiday together. They have come to a meeting
// point
// (the start of the journey) using N cars. There are P[K] people and S[K] seats
// in the K-th
// car for K in range [O..N-1). Some of the seats in the cars may be free, so it
// is possible
// for some of the friends to change the car they are in. The friends have
// decided that,
// in order to be ecological, they will leave some cars parked at the meeting
// point and
// travel with as few cars as possible.

// Write a function:
// class Solution {
// public int solution(int[] P, int[] S);
// }

// that, given two arrays P and S, consisting of N integers each, returns the
// minimum number
// of cars needed to take all of the friends on holiday.

// # Examples:
// 1. Given P = [1, 4, 1] and S = [1, 5, 1], the function should return 2. A
// person from car
// number 0 can travel in car number 1 instead. This way, car number 0 can be
// left parked at the meeting point.
// 2. Given P = [4, 4, 2, 4] and S = [5, 5, 2, 5], the function should return 3.
// One person
// from car number 2 can travel in car number 0 and other person from car number
// 2 can travel in car number
// 3. Given P = [2, 3, 4, 2] and S = [2, 5, 7, 2], the function should return 2.
// Passengers
// from car number 0 can travel in car number 1 and passengers from car number 3
// can travel in car number 2.

// Write an efficient algorithm for the following assumptions:
// • N is an integer within the range (1..100,000);
// • each element of arrays P and S is an integer within the range [1..9];
// • every friend had a seat in the car they came in; that is, P[K] < S[K] for
// each K within the range [0..N-1].

package My_Interview_Ques;

import java.util.*;

public class Q01MinimumCar {
    // LOGIC
    // (I) Calculate total number of person.
    // (II) reverse sort the S
    // (III) Traverse on S, and simlutaneously place people on seats.
    // T = O(nlogn)

    public static int solution(int[] P, int[] S) {

        int n = P.length;
        int totalPerson = 0;
        for (int i : P) {
            totalPerson += i;
        }

        Arrays.sort(S);
        reverse(S);
        int count = 0;

        int ptr = 0;
        while (ptr < n) {
            if (totalPerson > 0) {
                totalPerson -= S[ptr++];
                count++;
            } else {
                return count;
            }
        }

        return count;

    }

    // reverse
    public static void reverse(int nums[]) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;

        }
    }

    public static void main(String args[]) {
        int[] P = { 4, 4, 2, 4 }, S = { 5, 5, 2, 5 }; // 3
        // int [] P = {1,4,1}, S ={1,5,1}; // 2
        // int[] P = { 2, 3, 4, 2 }, S = { 2, 5, 7, 2 }; // 2

        int ans = solution(P, S);
        System.out.println(ans);
    }
}