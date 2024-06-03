**Problem Statement**: Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

Link: https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

---------------------------------------------------------------------------------

## Naive Approach (Brute-force approach)

Here, in this approach, we are going to generate all possible subarrays to solve this problem.

How to generate all possible subarrays?
We will select all possible starting indices(say i) and all possible ending indices(say j) to generate all possible subarrays. The possible starting indices i.e. i can vary from index 0 to index n-1(i.e. The last index). For every index i, the possible ending index j can vary from i to n-1. So, the nested loops to generate all possible subarrays will be like the following:

![image](https://github.com/balotraprashant/a2z/assets/69639884/90e15386-fcc1-4735-a3a3-18acde8f2d08)

Approach:
The steps are as follows:

- First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = size of the array).
- Inside the loop, we will run another loop(say j) that will signify the ending index of the subarray. For every subarray starting from index i, the possible ending index can vary from index i to n-1(n = size of the array).
- After that for each subarray starting from index i and ending at index j (i.e. arr[i….j]), we will run another loop to calculate the sum of all the elements(of that particular subarray).
- If the sum equals k, we will consider its length i.e. (j-i+1). Among all such subarrays, we will consider the maximum length by comparing all the lengths.

---------------------------------------------------------------------------------

## Better Approach (Using two loops)

The steps are as follows:

- First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = array size).
- Inside the loop, we will run another loop(say j) that will signify the ending index as well as the current element of the subarray. For every subarray starting from the index i, the possible ending index can vary from index i to n-1(n = size of the array).
- Inside loop j, we will add the current element to the sum of the previous subarray i.e. sum = sum + arr[j]. 
- If the sum is equal to k, we will consider its length i.e. (j-i+1). Among all such subarrays with sum k, we will consider the one with the maximum length by comparing all the lengths.

**Intuition**: If we carefully observe, we can notice that to get the sum of the current subarray we just need to add the current element(i.e. arr[j]) to the sum of the previous subarray i.e. arr[i….j-1].

- Assume previous subarray = arr[i……j-1]
- current subarray = arr[i…..j]
- Sum of arr[i….j] = (sum of arr[i….j-1]) + arr[j]

This is how we can remove the third loop and while moving the j pointer, we can calculate the sum.

---------------------------------------------------------------------------------

## Optimal Approach (Using Hashing)

In this approach, we are using the concept of the prefix sum to solve this problem. Here, the prefix sum of a subarray ending at index i, simply means the sum of all the elements of that subarray.

**Observation**: Assume, the prefix sum of a subarray ending at index i is x. In that subarray, we will search for another subarray ending at index i, whose sum equals k. Here, we need to observe that if there exists another subarray ending at index i with sum k, then the prefix sum of the rest of the subarray will be x-k. The below image will clarify the concept:

![image](https://github.com/balotraprashant/a2z/assets/69639884/721999ca-1861-4275-931a-a6aa4c7903d6)

Now, for a subarray ending at index i with the prefix sum x, if we remove the part with the prefix sum x-k, we will be left with the part whose sum is equal to k. And that is what we want.

That is why, instead of searching the subarrays with sum k, we will keep track of the prefix sum of the subarrays generated at every index using a map data structure. 

In the map, we will store every prefix sum calculated, with the index(where the subarray with that prefix sum ends) in a <key, value> pair. Now, at index i, we just need to check the map data structure to get the index i.e. preSumMap[x-k] where the subarray with the prefix sum x-k ends. Then we will simply subtract that index i.e. preSumMap[x-k] from the current index i to get the length of the subarray with sum k i.e. len = i -preSumMap[x-k].

We will apply the above process for all possible indices of the given array. The possible values of the index i can be from 0 to n-1(where n = size of the array).

**Edge Case**: Why do we need to check the map if the prefix sum already exists?

In the algorithm, we have seen that at step 3.4, we are checking the map if the prefix sum already exists, and if it does we are not updating it. Let’s understand the reason by considering the following example:
Assume the given array is {2, 0, 0, 3}. If we apply the algorithm to the given array without checking, it will be like the following:

![image](https://github.com/balotraprashant/a2z/assets/69639884/6ec2adbc-7a12-4723-8df6-8bbaa377e3d3)

In steps 2 and 3 the element at index i is 0. So, in those steps, the prefix sum remains the same but the index is getting updated in the map. Now, when index i reaches the end, it calculates the length i.e. i-preSumMap[rem] = 3-2 = 1. Here it is considering only the subarray [3] which is incorrect as the longest subarray we can get is [0, 0, 3] and hence the length should be 3.

Now, to avoid this edge case i.e. to maximize the calculated length, we need to observe the formula we are using to calculate the length i.e. len = i - preSumMap[rem].

Now, if we minimize the term preSumMap[rem] (i.e. the index where the subarray with sum x-k ends), we will get the maximum length. That is why we will consider only the first or the leftmost index where the subarray with sum x-k ends. After that, we will not update that particular index even if we get a similar subarray ending at a later index.

So, we will check the map before inserting the prefix sum. If it already exists in the map, we will not update it but if it is not present, we will insert it for the first time.

---------------------------------------------------------------------------------

## Optimal Approach (Using 2 pointers)

This approach works for Array having only positive elements. The steps are as follows:

- First, we will take two pointers: left and right, initially pointing to the index 0.
- The sum is set to a[0] i.e. the first element initially.
- Now we will run a while loop until the right pointer crosses the last index i.e. n-1.
- Inside the loop, we will do the following:
- We will use another while loop and it will run until the sum is lesser or equal to k.
- Inside this second loop, from the sum, we will subtract the element that is pointed by the left pointer and increase the left pointer by 1.
- After this loop gets completed, we will check if the sum is equal to k. If it is, we will compare the length of the current subarray i.e. (right-left+1) with the existing one and consider the maximum one.
- Then we will move forward the right pointer by 1. If the right pointer is pointing to a valid index(< n) after the increment, we will add the element i.e. a[right] to the sum.
- Finally, we will return the maximum length.

**Intuition:** We are using two pointers i.e. left and right. The left pointer denotes the starting index of the subarray and the right pointer denotes the ending index. Now as we want the longest subarray, we will move the right pointer in a forward direction every time adding the element i.e. a[right] to the sum. But when the sum of the subarray crosses k, we will move the left pointer in the forward direction as well to shrink the size of the subarray as well as to decrease the sum. Thus, we will consider the length of the subarray whenever the sum becomes equal to k.
The below dry run will clarify the intuition.

**Dry run:**

![image](https://github.com/balotraprashant/a2z/assets/69639884/23578074-68a8-4600-b980-4a6243bf1e98)
