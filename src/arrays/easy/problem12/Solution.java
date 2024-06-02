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
}
