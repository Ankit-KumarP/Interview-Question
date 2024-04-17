// (23/02/2024, 18:02) | Oracle
// QUES:
// Question 1: Given an array of Integers which is the level order traversal of
// a binary tree, And asked me to find out whether it is a binary search tree or
// not.
// Input : [8,5,11,null,null,10,12,7,null]
// Output : False

// Input : [8,5,13,null,null,10,16,9,14]
// Output : False

// Input : [8,5,13,null,null,10,16,9,11]
// Output : True

package My_Interview_Ques;

import java.util.*;
import java.lang.*;

public class Q05Tree {

    // LOGIC: using a Node class that keep the value of min, max and current node
    // value of each node of tree. + Queue DS
    // (I)For each node keep the details: val = value of current node, min = minimum
    // value possible for its left child, max = maximum value possible for its right
    // child.
    // (II) for any node its left child value lies between = (min,val);
    // (III) for any node its right child value lies between = ( val, max);
    // T = O(N) | S = O(N)

    public static boolean isBST(int[] arr, int n) {

        if (arr.length == 0)
            return true;
        Node root = new Node();
        root.val = arr[0];
        root.min = Integer.MIN_VALUE;
        root.max = Integer.MAX_VALUE;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int size = q.size();
        int ptr = 1;

        while (ptr < n && size != 0) {

            boolean flag1 = true, flag2 = true;

            Node newNode = new Node();
            newNode = q.poll();
            int val = newNode.val;
            int min = newNode.min;
            int max = newNode.max;

            // checking if it can be left node
            if (arr[ptr] == -1) {
                flag1 = false;
                ptr++;
            }
            if (flag1) {
                if (arr[ptr] > min && arr[ptr] < val) {
                    System.out.println(arr[ptr] + "  left  " + val);
                    newNode = new Node();
                    newNode.val = arr[ptr];
                    newNode.min = min;
                    newNode.max = val;
                    q.add(newNode);
                    ptr++;
                } else
                    return false;
            }
            newNode = new Node();

            // cheking if it can be right node

            if (arr[ptr] == -1) {
                flag2 = false;
                ptr++;
            }
            if (flag2) {
                if (ptr < n && arr[ptr] < max && arr[ptr] > val) {
                    System.out.println(arr[ptr] + "  right  " + val);
                    newNode.val = arr[ptr];
                    newNode.min = val;
                    newNode.max = max;
                    q.add(newNode);
                    ptr++;
                } else
                    return false;
            }

            size = q.size();
        }

        return true;

    }

    public static void main(String[] args) {

        // int[] arr = { 8, 5, 11, -1, -1, 10, 12, 7, -1 }; //
        // [8,5,11,null,null,10,12,7,null], false
        // int [] arr = {8,5,13,-1,-1,10,16,9,11}; // [8,5,13,null,null,10,16,9,11],
        // true
        // int[] arr = { 8, 5, 13, -1, -1, 10, 16, 9, 14 };//
        // [8,5,13,null,null,10,16,9,14], false
        int[] arr = { 4, 2, 7,1, 3 }; // true

        boolean ans = isBST(arr, arr.length);
        System.out.println(ans);
    }
}

// Node
class Node {
    int val;
    int min;
    int max;
}