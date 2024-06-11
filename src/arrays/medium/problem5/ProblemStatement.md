**Problem Statement**: You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

**Link**: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

--------------------------------------------------------------------

## Brute Force Approach

- Use a for loop of ‘i’ from 0 to n.
- Use another for loop of j from ‘i+1’ to n.
- If arr[j] > arr[i] , take the difference and compare  and store it in the maxPro variable.
- Return maxPro.

![image](https://github.com/balotraprashant/a2z/assets/69639884/8d1de517-7708-47f6-b0db-661f21a74d6f)

--------------------------------------------------------------------

## Optimal Approach

We will linearly travel the array. We can maintain a minimum from the start of the array and compare it with every element of the array, if it is greater than the minimum then take the difference and maintain it in max, otherwise update the minimum.

Approach:

- Create a variable maxPro and store 0 initially.
- Create a variable minPrice and store some larger value(ex: MAX_VALUE) value initially.
- Run a for loop from 0 to n.
- Update the minPrice if it is greater than the current element of the array
- Take the difference of the minPrice with the current element of the array and compare and maintain it in maxPro.
- Return the maxPro.

![image](https://github.com/balotraprashant/a2z/assets/69639884/2175ff8a-5dd6-4287-acea-4cb258757913)
