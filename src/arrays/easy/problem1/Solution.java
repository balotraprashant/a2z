package arrays.easy.problem1;

public class Solution {
    static int largestElement(int[] arr, int n) {
        // Write your code here.
        int largest = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            largest = Math.max(largest, arr[i]);
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1, 7};
        System.out.println(largestElement(arr, arr.length));
    }
}
