Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/

```
class Solution {
    public int longestConsecutive(int[] nums) {
        
        // if(nums.length<1) return 0;

        // // Brute Force Approach

        // int longest = 1;
        // //pick a element and search for its
        // //consecutive numbers:
        // for (int i = 0; i < nums.length; i++) {
        //     int x = nums[i];
        //     int cnt = 1;
        //     //search for consecutive numbers
        //     //using linear search:
        //     while (linearSearch(nums, x + 1)) {
        //         x += 1;
        //         cnt += 1;
        //     }

        //     longest = Math.max(longest, cnt);
        // }
        // return longest;

        // -----------------------------------------------------------------------------------

        // Better Approach

        Arrays.sort(nums);
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 0;

        //find longest sequence:
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == lastSmaller) {
                //a[i] is the next element of the
                //current sequence.
                cnt += 1;
            } else if (nums[i] != lastSmaller) {
                cnt = 1;
            }
            lastSmaller = nums[i];
            longest = Math.max(longest, cnt);
        }
        return longest;

        // -----------------------------------------------------------------------------------

        // My Approach

        // TreeSet<Integer> ts = Arrays.stream(nums).boxed()
        //                         .collect(Collectors.toCollection(TreeSet::new));

        // Integer longest = 1;
        // Integer longer = 1;

        // Iterator<Integer> iterator = ts.iterator();
        // if (iterator.hasNext()) {
        //     Integer current = iterator.next();
        //     while (iterator.hasNext()) {
        //         Integer next = iterator.next();
        //         if (next == current + 1) {
        //             longer++;
        //             longest = Math.max(longest, longer);
        //         } else {
        //             longer = 1;
        //         }
        //         current = next;
        //     }
        // }

        // return (int)longest;

        // -----------------------------------------------------------------------------------

        // Optimal Approach

        // int longest = 1;
        // HashSet<Integer> set = new HashSet<>();
    
        // for(int element: nums) set.add(element);

        // for(int element: set) {
        //     if(!set.contains(element-1)){
        //         int count = 1;
        //         int x = element;
        //         while(set.contains(x+1)) {
        //             x++;
        //             count++;
        //         }

        //         longest = Math.max(count, longest);
        //     }
        // }

        // return longest;
    }

    public static boolean linearSearch(int[] arr, int x) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==x) return true;
        }
        return false;
    }
}
```
