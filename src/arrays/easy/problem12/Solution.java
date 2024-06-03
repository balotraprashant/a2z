package arrays.easy.problem12;

public class Solution {
    // Function for finding maximum and value pair
    // Brute Force Approach
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int maxLength = Integer.MIN_VALUE;
        int currLength = 0;
        
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=i; j<N; j++) {
                sum += A[j];
                
                currLength = j-i+1;
                if(sum==K) {
                    maxLength = Math.max(maxLength, currLength);
                }
            }
        }
        
        return maxLength;
    }

    
    // Using Hashing (Map)
     public static int getLongestSubarrayUsingHashMap(int []a, int k) {
        int n = a.length; // size of the array.

        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            int rem = sum - k;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int curr = 0,max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            curr += A[i];
            if (curr == K) {
                max = Math.max(max,i-0+1);
            }
            if (map.containsKey(curr - K)) {
                max = Math.max(max,i-map.get(curr - K));
            }
            if(!map.containsKey(curr))
                map.put(curr, i);
        }
        return max;
    }

    // Optimal Approach (Two pointers)
    // Only works with positive elements array
    public static int getLongestSubarray(int []a, long k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }
}
