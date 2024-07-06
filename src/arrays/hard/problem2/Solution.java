package arrays.hard.problem2;

class Solution {

    // My Bruteforce Approach
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length;
        if(n<3) {
            for(int i=0; i<n; i++) {
                if(!res.contains(nums[i])) {
                    res.add(nums[i]);
                }
            }
            return res;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for(HashMap.Entry<Integer, Integer> entry: hm.entrySet()) {
            if(entry.getValue() > n/3) res.add(entry.getKey());
        }

        return res;
    }
}
