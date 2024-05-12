package arrays.easy.problem4;

import java.util.HashSet;

// Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class Solution {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3,3};
        int k = removeDuplicates(arr);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //Brute Force Approach
//    static int removeDuplicates(int[] arr) {
//        HashSet< Integer > set = new HashSet < > ();
//        for (int i = 0; i < arr.length; i++) {
//            set.add(arr[i]);
//        }
//        int k = set.size();
//        int j = 0;
//        for (int x: set) {
//            arr[j++] = x;
//        }
//        return k;
//    }

    // Optimal Approach
    static int removeDuplicates(int[] nums) {
        int i = 0;

        for(int j=1; j<nums.length; j++) {
            if(nums[i]!=nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }
}
