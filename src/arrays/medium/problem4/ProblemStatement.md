**Problem Statement**: Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.

**Link**: https://leetcode.com/problems/maximum-subarray/description/

**Examples**

```
Example 1:
Input:
 arr = [-2,1,-3,4,-1,2,1,-5,4] 

Output:
 6 

Explanation:
 [4,-1,2,1] has the largest sum = 6. 

Examples 2:
Input:
 arr = [1] 

Output:
 1 

Explanation:
 Array has only one element and which is giving positive sum of 1.
```

--------------------------------------------------------------------------------

## Brute Force Approach

The steps are as follows:

- First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = size of the array).
- Inside the loop, we will run another loop(say j) that will signify the ending index of the subarray. For every subarray starting from the index i, the possible ending index can vary from index i to n-1(n = size of the array).
- After that for each subarray starting from index i and ending at index j (i.e. arr[i….j]), we will run another loop to calculate the sum of all the elements(of that particular subarray).

Dry Run

Subarrays are marked with yellow color.

![image](https://github.com/balotraprashant/a2z/assets/69639884/6dd8b39f-d510-4fd6-808d-38407b0833d5)

--------------------------------------------------------------------------------

## Better Approach

**Intuition**: If we carefully observe, we can notice that to get the sum of the current subarray we just need to add the current element(i.e. arr[j]) to the sum of the previous subarray i.e. arr[i….j-1].

- Assume previous subarray = arr[i……j-1]
- current subarray = arr[i…..j]
- Sum of arr[i….j] = (sum of arr[i….j-1]) + arr[j]

This is how we can remove the third loop and while moving j pointer, we can calculate the sum.

The steps are as follows:

- First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = array size).
- Inside the loop, we will run another loop(say j) that will signify the ending index as well as the current element of the subarray. For every subarray starting from index i, the possible ending index can vary from index i to n-1(n = size of the array).
- Inside loop j, we will add the current element to the sum of the previous subarray i.e. sum = sum + arr[j]. Among all the sums the maximum one will be the answer.

**Dry Run**

![image](https://github.com/balotraprashant/a2z/assets/69639884/ddd69df5-d089-44b3-9477-bd197a6c0517)

--------------------------------------------------------------------------------

## Optimal Approach

The intuition of the algorithm is not to consider the subarray as a part of the answer if its sum is less than 0. **A subarray with a sum less than 0 will always reduce our answer and so this type of subarray cannot be a part of the subarray with maximum sum**.

The steps are as follows:

- We will run a loop(say i) to iterate the given array.
- Now, while iterating we will add the elements to the sum variable and consider the maximum one.
- If at any point the sum becomes negative we will set the sum to 0 as we are not going to consider it as a part of our answer.

Note: In some cases, the question might say to consider the sum of the empty subarray while solving this problem. So, in these cases, before returning the answer we will compare the maximum subarray sum calculated with 0(i.e. The sum of an empty subarray is 0). And after that, we will return the maximum one.

For e.g. if the given array is {-1, -4, -5}, the answer will be 0 instead of -1 in this case.

--------------------------------------------------------------------------------

## Follow-up question

There might be more than one subarray with the maximum sum. We need to print any of them.

**Intuition**: Our approach is to store the starting index and the ending index of the subarray. Thus we can easily get the subarray afterward without actually storing the subarray elements.

If we carefully observe our algorithm, we can notice that the subarray always starts at the particular index where the sum variable is equal to 0, and at the ending index, the sum always crosses the previous maximum sum(i.e. maxi).

So, we will keep a track of the starting index inside the loop using a start variable.
We will take two variables ansStart and ansEnd initialized with -1. And when the sum crosses the maximum sum, we will set ansStart to the start variable and ansEnd to the current index i.e. i.
The rest of the approach will be the same as Kadane’s Algorithm.

```
public static long maxSubarraySum(int[] arr, int n) {
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;

        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < n; i++) {

            if (sum == 0) start = i; // starting index

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        //printing the subarray:
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]n");

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

        return maxi;
    }
```
