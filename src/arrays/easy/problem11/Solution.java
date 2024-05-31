package arrays.easy.problem11;

public class Solution {

  // Better Approach
  // public int singleNumber(int[] nums) {
  //       if(nums.length==0) return 0;

  //       HashMap<Integer, Integer> hm = new HashMap<>();
  //       for(int i=0; i<nums.length; i++) {
  //           hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
  //       }

  //       for(Entry<Integer, Integer> entry: hm.entrySet()) {
  //           if(entry.getValue()==1) return entry.getKey();
  //       }
  //       return nums[0];
  //   }
  
  // Optimal Approach
  public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
