package arrays.hard.problem7;

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // Brute Force
        // int[] hash = new int[n + 1]; // hash array

        // //update the hash array:
        // for (int i = 0; i < n; i++) {
        //     hash[arr[i]]++;
        // }

        // //Find the repeating and missing number:
        // int repeating = -1, missing = -1;
        // for (int i = 1; i <= n; i++) {
        //     if (hash[i] == 2) repeating = i;
        //     else if (hash[i] == 0) missing = i;

        //     if (repeating != -1 && missing != -1)
        //         break;
        // }
        // int[] ans = {repeating, missing};
        // return ans;
        
        // Optimal Approach 1
        int xr = 0;

        //Step 1: Find XOR of all elements:
        for (int i = 0; i < n; i++) {
            xr = xr ^ arr[i];
            xr = xr ^ (i + 1);
        }

        //Step 2: Find the differentiating bit number:
        int number = (xr & ~(xr - 1));

        //Step 3: Group the numbers:
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            //part of 1 group:
            if ((arr[i] & number) != 0) {
                one = one ^ arr[i];
            }
            //part of 0 group:
            else {
                zero = zero ^ arr[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            //part of 1 group:
            if ((i & number) != 0) {
                one = one ^ i;
            }
            //part of 0 group:
            else {
                zero = zero ^ i;
            }
        }

        // Last step: Identify the numbers:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == zero) cnt++;
        }

        if (cnt == 2) return new int[] {zero, one};
        return new int[] {one, zero};
    }
}
