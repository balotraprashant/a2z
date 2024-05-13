package arrays.hard.problem4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    // Brute Force Approach

    // public List<List<Integer>> fourSum(int[] nums, int target) {
    //     Set<List<Integer>> set = new HashSet<>();

    //     for (int i=0; i<nums.length; i++) {
    //         for (int j=i+1; j<nums.length; j++) {
    //             for (int k=j+1; k<nums.length; k++) {
    //                 for (int l=k+1; l<nums.length; l++) {
    //                     if(target==nums[i]+nums[j]+nums[k]+nums[l]){
    //                         ArrayList<Integer> temp = new ArrayList<>();
    //                         temp.add(nums[i]);
    //                         temp.add(nums[j]);
    //                         temp.add(nums[k]);
    //                         temp.add(nums[l]);
    //                         temp.sort(Integer::compareTo);
    //                         set.add(temp);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     List<List<Integer>> res = new ArrayList<>(set);
    //     return res;
    // }

    // Better Approach

    // public List<List<Integer>> fourSum(int[] nums, int target) {
    //     Set<List<Integer>> set = new HashSet<>();

    //     for (int i=0; i<nums.length; i++) {
    //         for (int j=i+1; j<nums.length; j++) {
    //             HashSet<Long> hs = new HashSet<>();
    //             for (int k=j+1; k<nums.length; k++) {
    //                 long sum = nums[i]+nums[j];
    //                 sum += nums[k];
    //                 long fourth = target - sum;
    //                 if(hs.contains(fourth)){
    //                     ArrayList<Integer> temp = new ArrayList<>();
    //                     temp.add(nums[i]);
    //                     temp.add(nums[j]);
    //                     temp.add(nums[k]);
    //                     temp.add((int)fourth);
    //                     temp.sort(Integer::compareTo);
    //                     set.add(temp);
    //                 }
    //                 hs.add((long)nums[k]);
    //             }
    //         }
    //     }
    //     List<List<Integer>> res = new ArrayList<>(set);
    //     return res;
    // }

    // Optimal Approach

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {

            if(i>0 && nums[i]==nums[i-1]) continue;

            for (int j=i+1; j<nums.length; j++) {

                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int k = j+1;
                int l = nums.length-1;

                while (k<l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if(sum>target) {
                        l--;
                    } else if(sum<target) {
                        k++;
                    } else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        res.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }
        return res;
    }
}
