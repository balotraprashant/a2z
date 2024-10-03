Problem Link: https://leetcode.com/problems/next-greater-element-i/description/

Brute Force Approach:

```
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // int[] res = new int[nums1.length];
        // for(int i=0; i<nums1.length; i++) {
        //     int x = nums1[i];
        //     for(int j=0; j<nums2.length; j++) {
        //         if(x==nums2[j]) {
        //             for(int k=j; k<nums2.length; k++) {
        //                 if(k+1 < nums2.length && nums2[k+1]>x) {
        //                     res[i] = nums2[k+1];
        //                     k = nums2.length;
        //                 } else {
        //                     res[i] = -1;
        //                 }
        //             }
        //             j = nums2.length;
        //         }
        //     }
        // }
        // return res;

        // Optimal Approach
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) stack.pop();

            if(stack.isEmpty())
                map.put(nums2[i], -1);
            else
                map.put(nums2[i], stack.peek());

            stack.push(nums2[i]);
        }

        for(int i=0; i<nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }
}
```


    // What we are doing:
    // 1. Traversing nums2 from right to left
    // 2. We have declared a stack, if stack is empty, we put (nums2[i], -1) to map
    // 3. If stack is not empty, we check nums2[i] > stack.peek(), if yes, we execute pop() operation for all such elements
    // 4. At last we push nums2[i] to stack
    // 5. Finally, we get elements from map using nums[i] as key
