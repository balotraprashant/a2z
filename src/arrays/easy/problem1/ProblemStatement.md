**Problem Statement**: Given an array, we have to find the largest element in the array.

**Examples**

Example 1:
Input:
arr[] = {2,5,1,3,0};
Output:
5
Explanation:
5 is the largest element in the array.

Example2:
Input:
arr[] = {8,10,5,7,9};
Output:
10
Explanation:
10 is the largest element in the array.
------------------------------------------
**Brute Force Approach**

Algorithm / Intuition
- Sorting

We can sort the array in ascending order, hence the largest element will be at the last index of the array.

Approach:

Sort the array in ascending order.

Print the (size of the array -1)th index.

**Time Complexity:** O(N*log(N))

**Space Complexity:** O(1)

------------------------------------------

**Optimal Approach**

Intuition:
We can maintain a max variable that will update whenever the current value is greater than the value in the max variable.

Approach:
- Create a max variable and initialize it with arr[0].
- Use a for loop and compare it with other elements of the array
- If any element is greater than the max value, update max value with the element’s value
- Print the max variable.

**Time Complexity:** O(N)

**Space Complexity:** O(1)