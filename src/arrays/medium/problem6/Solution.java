package arrays.medium.problem6;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Brute Force Approach
        // ArrayList<Integer> positives = new ArrayList<>();
        // ArrayList<Integer> negatives = new ArrayList<>();
        // for(int i=0; i<nums.length; i++) {
        //     if(nums[i]>=0) {
        //         positives.add(nums[i]);
        //     } else {
        //         negatives.add(nums[i]);
        //     }
        // }

        // for(int i=0; i<nums.length/2; i++) {
        //     nums[2*i] = positives.get(i);
        //     nums[2*i+1] = negatives.get(i);
        // }
        // return nums;

        int[] ans = new int[nums.length];
        int posIndex = 0, negIndex = 1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]<0) {
                ans[negIndex] = nums[i];
                negIndex += 2;
            } else {
                ans[posIndex] = nums[i];
                posIndex +=2;
            }
        }
        return ans;
    }
}
