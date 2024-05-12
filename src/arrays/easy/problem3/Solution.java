package arrays.easy.problem3;

public class Solution {
    static boolean isSorted(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5}, n = 5;

        System.out.println(isSorted(arr, n));
    }


//    There is another version of this question, where a sorted array can be rotated array

//    Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
//
//    There may be duplicates in the original array.
//
//    Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

//    Example:
//
//    Input: nums = [3,4,5,1,2]
//    Output: true
//    Explanation: [1,2,3,4,5] is the original sorted array.
//    You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].

//    public boolean check(int[] nums) {
//        int count = 0;
//
//        for(int i = 0; i < nums.length-1; i++){
//            if(nums[i] > nums[i+1])
//                count++;
//        }
//
//        if(count == 0)
//            return true;
//        else if(count > 1)
//            return false;
//        else if(nums[0] >= nums[nums.length-1])
//            return true;
//        else
//            return false;
//    }
}
