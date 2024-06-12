package arrays.medium.problem5;

public class Solution {
  public int maxProfit(int[] prices) {

        // Brute Force Approach
        // int maxProfit = 0;
        // for(int i=0; i<prices.length; i++) {
        //     for(int j=i+1; j<prices.length; j++) {
        //         int profit = prices[j] - prices[i];
        //         maxProfit = Math.max(profit, maxProfit);
        //     }
        // }

        // Optimal Approach
        int maxProfit = 0;
        int minProfit = Integer.MAX_VALUE;

        for (int i=0; i<prices.length; i++) {
            minProfit = Math.min(minProfit, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-minProfit);
        }

        return maxProfit;
    }
}
