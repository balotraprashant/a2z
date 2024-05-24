package arrays.easy.problem5;

class Solution {

    // Brute Force Approach
    public void rotateRight(int[] nums, int k) {
        int n = nums.length;
        // int[] res = new int[n];

        // if (n == 0) {
        //     return;
        // }

        // // Take modulus for checking if k is divisible by n, else value of k will be same
        // k = k % n;

        // for(int i=0; i+k<n; i++) {
        //     res[i+k] = nums[i];
        // }

        // int p = k;
        // for(int i=0; i<k; i++) {
        //     res[i] = nums[n-p];
        //     p--;
        // }

        // for(int i=0; i<res.length; i++){
        //     nums[i] = res[i];
        // }

        /* Next Approach */

        if (n == 0) {
            return;
        }

        // Take modulus for checking if k is divisible by n, else value of k will be same
        k = k % n;
        
        // if k will be greater than n when k/n > n, it means numsay will be rotated by n elements more than n times 
        if (k > n) {
            return;
        }

        int[] temp = new int[k];
        //                                  4      -4         4
        // iteration 1: n = 7, k = 3, temp[(n-k) - n+k] = nums[n-k] = temp[0] = nums[4];
        
        //                                  5      -4         5
        // iteration 2: n = 7, k = 3, temp[(n-k) - n+k] = nums[n-k] = temp[1] = nums[5];

        //                                  6      -4         6
        // iteration 3: n = 7, k = 3, temp[(n-k) - n+k] = nums[n-k] = temp[2] = nums[6];
        for (int i = n - k; i < n; i++) {
            temp[i - n + k] = nums[i];
        }

        //                                  4      -4         4
        // iteration 1: n = 7, k = 3, temp[(n-k) - n+k] = nums[n-k] = temp[0] = nums[4];
        
        //                                  5      -4         5
        // iteration 2: n = 7, k = 3, temp[(n-k) - n+k] = nums[n-k] = temp[1] = nums[5];

        //                                  6      -4         6
        // iteration 3: n = 7, k = 3, temp[(n-k) - n+k] = nums[n-k] = temp[2] = nums[6];
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
