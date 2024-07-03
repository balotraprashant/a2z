package arrays.medium.problem13;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        int prefixSum = 0;
        int count = 0;

        hm.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            // add current element to prefix Sum:
            prefixSum += nums[i];

            // Calculate x-k:
            int remove = prefixSum - k;

            // Add the number of subarrays to be removed:
            count += hm.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
