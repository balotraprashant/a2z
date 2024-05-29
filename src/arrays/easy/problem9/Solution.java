package arrays.easy.problem9;

public class Solution {
  // My BruteForce Approach
  // public int missingNumber(int[] nums) {
  //     Arrays.sort(nums);

  //     for(int i=0; i<nums.length; i++) {
  //         if(nums[i]!=i) {
  //             return i;
  //         }
  //     }

  //     return nums.length;
  // }

  // XOR Approach
  // public int missingNumber(int[] nums) {
  //     int xor = 0;
  //     int n = nums.length;

  //     for (int i=0; i<n; i++)
  //         xor ^= i ^ nums[i];

  //     return xor ^ n;
  // }

  // Submission Approach - Optimal Solution
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long expectedSum = (n * (n+1))/2;
        long actualSum = 0;

        for(int i=0; i<n; i++) {
            actualSum+= nums[i];
        }

        return (int)(expectedSum-actualSum);
    }
}
