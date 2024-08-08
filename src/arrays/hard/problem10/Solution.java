class Solution {
    public int reversePairs(int[] nums) {

        // Brute Force
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(nums[i] > nums[j]*2) {
                    count++;
                }
            }
        }

        return count;
    }
}
