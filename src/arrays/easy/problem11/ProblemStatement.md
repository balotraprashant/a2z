**Problem Statement**: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.

Link: https://leetcode.com/problems/single-number/description/

```
Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1
```
---------------------------------------------------------------------------------
### Brute Force Approach

The steps are as follows:

- First, we will run a loop(say i) to select the elements of the array one by one.
- For every element arr[i], we will perform a linear search using another loop and count its occurrence.
- If for any element the occurrence is 1, we will return it.

---------------------------------------------------------------------------------

### Better Approach 1

**(Array hashing)**

In order to hash using an array, we need to first find the maximum element(say maxElement) to get the range of the hash array. The index of the hash array will represent the elements of the given array and the value stored in that index will be the number of occurrences. Now, the size of the array must be maxElement+1 as we need to hash the maxElement itself.

The steps are as follows:

- First, we will find the maximum element(say maxElement) to know the size of the hash array.
- Then we will declare a hash array of size maxElement+1.
- Now, using another loop we will store the elements of the array along with their frequency in the hash array. (i.e. hash[arr[i]]++)
- After that, using another loop we will iterate over the hash array, and try to find the element for which the frequency is 1, and finally, we will return that particular element.

Note: While searching for the answer finally, we can either use a loop from 0 to n(i.e. Size of the array) or use a loop from 0 to maxElement. So, the time complexity will change accordingly.

Now, using array hashing it is difficult to hash the elements of the array if it contains negative numbers or a very large number. So to avoid these problems, we will be using the map data structure to hash the array elements.

----------------------------------------------------------------------------------

### Better Approach 2

**(Hashing using the map data structure)**

The steps are as follows:

- First, we will declare a map.
- Now, using a loop we will store the elements of the array along with their frequency in the map data structure.
- Using another loop we will iterate over the map, and try to find the element for which the frequency is 1, and finally, we will return that particular element.

----------------------------------------------------------------------------------

### Optimal Approach

**(Using XOR)**

Two important properties of XOR are the following:

- XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
- XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.  ←Property 2

Here all the numbers except the single number appear twice and so will form a pair. Now, if we perform XOR of all array elements, the XOR of each pair will result in 0 according to the XOR property 1. The result will be = 0 ^ (single number) = single number (according to property 2).

So, if we perform the XOR of all the numbers of the array elements, we will be left with a single number.
