package arrays.medium.problem2;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    //Better Approach
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0) cnt0++;
            else if (arr.get(i) == 1) cnt1++;
            else cnt2++;
        }

        //Replace the places in the original array:
        for (int i = 0; i < cnt0; i++) arr.set(i, 0); // replacing 0's

        for (int i = cnt0; i < cnt0 + cnt1; i++) arr.set(i, 1); // replacing 1's

        for (int i = cnt0 + cnt1; i < n; i++) arr.set(i, 2); // replacing 2's
    }

    public static void main(String args[]) {
        int n = 6;
        Integer[] a = new Integer[] {0, 2, 1, 2, 0, 1};
        int[] colors = new int[] {0, 2, 1, 2, 0, 1};
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(a));
        sortArray(arr, n);
        sortColors(colors);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

        System.out.println("After sorting:");
        for (int i = 0; i < colors.length; i++) {
            System.out.print(colors[i] + " ");
        }
        System.out.println();

    }

    //Optimal Solution
    public static void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length-1;
        while (mid<=right) {
            if (nums[mid]==0) {
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            } else if (nums[mid]==1) {
                mid++;
            } else if (nums[mid]==2) {
                int temp = nums[right];
                nums[right] = nums[mid];
                nums[mid] = temp;
                right--;
            }
        }
    }
}
