**Problem Statement**: You are given an array of integers, your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order.

Link: https://leetcode.com/problems/move-zeroes/description/

## Brute Force Approach
The extremely naive solution, we can think of, involves the use of an extra array. The algorithm is as follows.

Algorithm:
- Suppose, there are N-X zeros and X non-zero elements in the array. We will first copy those X non-zero elements from the original array to a temporary array. 
- Then, we will copy the elements from the temporary array one by one and fill the first X places of the original array. 
- The last N-X places of the original array will be then filled with zero. Now, our task is completed.

**Time Complexity**: O(N) + O(X) + O(N-X) ~ O(2*N), where N = total no. of elements,
X = no. of non-zero elements, and N-X = total no. of zeros.
Reason: O(N) for copying non-zero elements from the original to the temporary array. O(X) for again copying it back from the temporary to the original array. O(N-X) for filling zeros in the original array. So, the total time complexity will be O(2*N).

**Space Complexity**: O(N), as we are using a temporary array to solve this problem and the maximum size of the array can be N in the worst case.
Reason: The temporary array stores the non-zero elements. In the worst case, all the given array elements will be non-zero.

## Optimal Approach
We can optimize the approach using 2 pointers i.e. i and j. The pointer j will point to the first 0 in the array and i will point to the next index.

Assume, the given array is {1, 0, 2, 3, 2, 0, 0, 4, 5, 1}. Now, initially, we will place the 2-pointers like the following:

The algorithm will be the following.

Algorithm:
- First, using a loop, we will place the pointer j. If we don’t find any 0, we will not perform the following steps.
- After that, we will point i to index j+1 and start moving the pointer using a loop.
- While moving the pointer i, we will do the following:
- If a[i] != 0 i.e. a[i] is a non-zero element: We will swap a[i] and a[j]. Now, the current j is pointing to the non-zero element a[i]. So, we will shift the pointer j by 1 so that it can again point to the first zero.
- Finally, our array will be set in the right manner.

## Faster Solution
We can optimize the approach using pointer left. The pointer left will initially point 0 index in the array.

The algorithm will be the following:

- First, we will run a loop from i=0 to nums.length-1, if nums[i]!=0, we will assign nums[left] = nums[i] and increment left.
- If nums[i]==0, we'll just continue.
- Finally we will run another loop from left to nums.length-1 and fill remaining elements with 0.
