package arrays.hard.problem2;

class Solution {
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

        // My Approach

        // HashMap<Integer, Integer> hm = new HashMap<>();
        // for(int i=0; i<n; i++) {
        //     hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        // }

        // for(HashMap.Entry<Integer, Integer> entry: hm.entrySet()) {
        //     if(entry.getValue() > n/3) res.add(entry.getKey());
        // }

        // Optimal Approach - Extended Moore's Voting Alorithm

        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        int count1 = 0;
        int count2 = 0;
        
        for(int i=0; i<n; i++) {
            if(count1==0 && nums[i]!=el2) {
                count1 = 1;
                el1 = nums[i];
            } else if (count2==0 && nums[i]!=el1) {
                count2 = 1;
                el2 = nums[i];
            } else if (nums[i]==el1) {
                count1 ++;
            } else if (nums[i]==el2) {
                count2 ++;
            } else {
                count1--;
                count2--; 
            }
        }

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        count1 = 0; count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) count1++;
            if (nums[i] == el2) count2++;
        }

        int mini = (int)(n / 3) + 1;
        if(count1 >= mini) res.add(el1);
        if(count2 >= mini) res.add(el2);

        return res;
    }
}
