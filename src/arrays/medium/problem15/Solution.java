package arrays.medium.problem15;

import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Brute Force

		// int count = 0;
        
        // for(int i=0; i<arr.size(); i++) {
        //     int xorr = 0;
        //     for(int j=i; j<arr.size(); j++) {
        //         xorr = xorr ^ arr.get(j);
        //         if(xorr==x) count++;
        //     }
        // }
        
        // return count;

		// Optimal Approach

        int n = arr.size();
        int xr = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(xr, 1);
        int count = 0;
        
        for(int i=0; i<n; i++) {
            xr = xr ^ arr.get(i);
            
            int rem = xr ^ x;
            
            if(hm.containsKey(rem)) {
                count += hm.get(rem);
            }
            
            if(hm.containsKey(xr)) {
                hm.put(xr, hm.get(xr) + 1);
            } else {
                hm.put(xr, 1);
            }
        }
        
        return count;
	}
}
