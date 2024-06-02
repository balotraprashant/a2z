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
}
