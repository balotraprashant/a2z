Problem Link: https://leetcode.com/problems/merge-sorted-array/description/

```
class Solution {
    public void merge(int[] left, int m, int[] right, int n) {
        int p1=m-1;
        int p2=n-1;
        int i=m+n-1;

        while(p2>=0) {
            if(p1>=0 && left[p1] > right[p2]){
                left[i--] = left[p1--];
            } else {
                left[i--] = right[p2--];
            }
        }

        // 1,2,3,0,0,0          2,5,6
        //     ^                    ^
        // 1,2,3,0,0,6          2,5,6
        //     ^                  ^
        // 1,2,3,0,5,6          2,5,6
        //     ^                ^  
        // 1,2,3,3,5,6          2,5,6
        //   ^                  ^  
        // 1,2,2,3,5,6          2,5,6
        //                     ^               --> Here p2 < 0
    }
}
```
