package arrays.medium.problem4;

class Solution {
    public int maxSubArray(int[] nums) {
        
        // Brute Force Approach
        // int maxSum = Integer.MIN_VALUE;
        // for(int i=0; i<nums.length; i++) {
        //     int sum = 0;
        //     for(int j=i; j<nums.length; j++) {
        //         sum += nums[j];
        //         maxSum = Math.max(maxSum, sum);
        //     }
        // }

        // return maxSum;

        // Optimal Approach
        // int maxSum = Integer.MIN_VALUE;
        // int sum = 0;
        // for(int i=0; i<nums.length; i++) {
        //     sum += nums[i];

        //     maxSum = Math.max(maxSum, sum);

        //     if(sum<0) {
        //         sum = 0;
        //     }
        // }

        // return maxSum;

        // Follow up Question
        int maxSum = Integer.MIN_VALUE; // maximum sum
        int sum = 0;

        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < nums.length; i++) {

            if (sum == 0) start = i; // starting index

            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;

                ansStart = start;
                ansEnd = i;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.print("start : " + ansStart + " ; " + "end  : " + ansEnd);

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

        return maxSum;
    }
}
