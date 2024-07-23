package arrays.medium.problem14;

//{ Driver Code Starts
import java.util.*;

class Solution
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Brute Force Approach
        
        // int maxLength = 0;
        
        // for(int i=0; i<n; i++) {
        //     int sum = 0;
        //     for(int j=i; j<n; j++) {
        //         sum += arr[j];
                
        //         if(sum==0) {
        //             maxLength = Math.max(maxLength, j-i+1);
        //         }
        //     }
        // }
        
        // return maxLength;
        
        // Optimal Approach
        
        // 15 -> 0
        // 13 -> 1
        // 15 -> 2
        // 7 -> 3
        // 8 -> 4
        // 15 -> 5
        
        int maxLength = 0;
        int prefixSum = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            prefixSum += arr[i];
            
            if(prefixSum == 0) {
                maxLength = i+1;
            } else {
                if(hm.get(prefixSum)!=null) {
                    int length = i - hm.get(prefixSum);
                    maxLength = Math.max(maxLength, length);
                } else {
                    hm.put(prefixSum, i);   
                }
            }
        }
        
        return maxLength;
    }
}
