package arrays.medium.problem3;

class Solution {
    public int majorityElement(int[] nums) {

        // Better Approach 
        // HashMap<Integer, Integer> hm = new HashMap<>();

        // for(int i=0; i<nums.length; i++) {
        //     hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

        //     if(hm.get(nums[i])>nums.length/2) return nums[i];
        // }

        // return nums[0];

        // Optimal Approach
        int count = 0;
        int element = nums[0];

        //applying the algorithm:
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                element = nums[i];
            } else if (element == nums[i]) count++;
            else count--;
        }

        //checking if the stored element
        // is the majority element:
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element) count1++;
        }

        if (count1 > (nums.length / 2)) return element;
        return -1;
    }
}
