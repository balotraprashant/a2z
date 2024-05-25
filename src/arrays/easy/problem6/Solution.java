package arrays.easy.problem6;

class Solution {
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

        int left = 0;
        for (int right = 0 ; right < nums.length ; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }

        for (; left < nums.length ; left++) {
            nums[left] = 0;
        }
    }
}
