package arrays.hard.problem9;

class Solution {
    public int maxProduct(int[] nums) {
        // int n = nums.length;
        // int maxProduct = Integer.MIN_VALUE;
        // int product = 1;
        // for(int i=0; i<n; i++) {
        //     product = product * nums[i];
        //     if(product > maxProduct) {
        //         maxProduct = product;
        //     }
        //     if(product<=0) {
        //         product = 1;
        
        //     }
        // }

        // return maxProduct;

        // int max = nums[0], min = nums[0], ans = nums[0];
        
        // for (int i = 1; i < nums.length; i++) {
            
        //     int temp = max;  // store the max because before updating min your max will already be updated
            
        //     max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
        //     min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            
        //     if (max > ans) {
        //         ans = max;
        //     }
        // }
        
        // return ans;

        int ans = nums[0];
    int dpMin = nums[0];
    int dpMax = nums[0];

    for (int i = 1; i < nums.length; ++i) {
      final int num = nums[i];
      final int prevMin = dpMin;
      final int prevMax = dpMax;
      if (num < 0) {
        dpMin = Math.min(prevMax * num, num);
        dpMax = Math.max(prevMin * num, num);
      } else {
        dpMin = Math.min(prevMin * num, num);
        dpMax = Math.max(prevMax * num, num);
      }
      ans = Math.max(ans, dpMax);
    }
    return ans;
    }
}
