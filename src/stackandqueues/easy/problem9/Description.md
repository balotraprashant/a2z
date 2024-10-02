Problem Link: https://leetcode.com/problems/next-greater-element-i/description/

Brute Force Approach:

```
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            int x = nums1[i];
            for(int j=0; j<nums2.length; j++) {
                if(x==nums2[j]) {
                    for(int k=j; k<nums2.length; k++) {
                        if(k+1 < nums2.length && nums2[k+1]>x) {
                            res[i] = nums2[k+1];
                            k = nums2.length;
                        } else {
                            res[i] = -1;
                        }
                    }
                    j = nums2.length;
                }
            }
        }
        return res;
    }
}
```
