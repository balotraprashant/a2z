package arrays.medium.problem9;

class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length<1) return 0;

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

        // Optimal Approach

        int longest = 1;
        HashSet<Integer> set = new HashSet<>();
    
        for(int element: nums) set.add(element);

        for(int element: set) {
            if(!set.contains(element-1)){
                int count = 1;
                int x = element;
                while(set.contains(x+1)) {
                    x++;
                    count++;
                }

                longest = Math.max(count, longest);
            }
        }

        return longest;
    }
}
