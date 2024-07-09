package binarysearch.ononedarrays.problem1;

class Solution {
    public int search(int[] nums, int target) {

        int mid = nums.length/2;
        int left = 0;
        int right = nums.length-1;
        while(left<=right) {
            if(nums[mid]==target) return mid;

            else if(nums[mid]<target) {
                left = mid+1;
                mid = (left+right)/2;
            }
            else {
                right = mid-1;
                mid = (left+right)/2;
            }
        }

        return -1;
    }
}
