package arrays.medium.problem7;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length; // size of the array.

        // Step 1: Find the break point:
        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                // index i is the break point
                ind = i;
                break;
            }
        }

        // If break point does not exist:
        if (ind == -1) {
            // reverse the whole array:
            for(int i = 0; i < n / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[n - i - 1];
                nums[n - i - 1] = temp;
            }
        } else {
            // Step 2: Find the next greater element
            //         and swap it with arr[ind]:
            for (int i = n - 1; i > ind; i--) {
                if (nums[i] > nums[ind]) {
                    int tmp = nums[i];
                    nums[i] = nums[ind];
                    nums[ind] = tmp;
                    break;
                }
            }

            // Step 3: reverse the right half:
            int left = ind+1;
            int right = n-1;
            
            while (left < right) {
                // Swap elements at left and right
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                // Move towards the middle
                left++;
                right--;
            }
        }
    }
}
