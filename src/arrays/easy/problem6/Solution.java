package arrays.easy.problem6;

public class Solution {
    public void moveZeroes(int[] nums) {
        // int n=nums.length;
        // int left = 0;
        // for(int i=0; i<n; i++) {
        //     if(nums[i]==0) {
        //         left = i;
        //         break;
        //     } else if(i==n-1) {
        //         return;
        //     }
        // }

        // int right = left+1;

        // while(right<n) {
        //     if(nums[right]!=0) {
        //         nums[left] = nums[right];
        //         nums[right] = 0;
        //         left++;
        //         right++;
        //     } else {
        //         right++;
        //     }
        // }

        // Simple and Fastest Approach

        int left = 0;
        for (int right = 0 ; right < nums.length ; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }

        for (; left < nums.length ; left++) {
            nums[left] = 0;
        }

        // Optimal Approach

        // int j = -1;
        // //place the pointer j:
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         j = i;
        //         break;
        //     }
        // }

        // //no non-zero elements:
        // if (j == -1) return;

        // //Move the pointers i and j
        // //and swap accordingly:
        // for (int i = j + 1; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         //swap a[i] & a[j]:
        //         int tmp = nums[i];
        //         nums[i] = nums[j];
        //         nums[j] = tmp;
        //         j++;
        //     }
        // }
    }
}
