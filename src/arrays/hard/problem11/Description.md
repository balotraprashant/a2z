Problem Link: https://leetcode.com/problems/maximum-product-subarray/description/

```
class Solution {
    public int maxProduct(int[] nums) {
        
        // Brute Force Approach

        // int maxPro = Integer.MIN_VALUE;
        // int n = nums.length;
        // for(int i=0; i<n; i++) {
        //     int product = 1;
        //     for(int j=i; j<n; j++) {
        //         product = product * nums[j];
        //         maxPro = Math.max(maxPro, product);
        //     }
        // }
        // return maxPro;

        // Optimal Approach
        int minProd = nums[0];
        int maxProd = nums[0];
        int result = nums[0];
    
        for(int i=1;i<nums.length;i++) {
            int temp = Math.max(nums[i], Math.max(maxProd*nums[i], minProd*nums[i]));
            minProd = Math.min(nums[i], Math.min(maxProd*nums[i], minProd*nums[i]));
            maxProd = temp;
            
            result = Math.max(result, maxProd);
        }
        
        return result;
    }
}
```
