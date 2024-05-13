**Problem Statement:** Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)

Examples

Input:
 nums = [2,0,2,1,1,0]
Output
: [0,0,1,1,2,2]

Input:
 nums = [2,0,1]
Output:
 [0,1,2]

Input:
 nums = [0]
Output:
 [0]

 -----------------------------------------------------------------------------------------------------------------

 **Better Approach**

 Keeping count of values

Intuition: Since in this case there are only 3 distinct values in the array so it's easy to maintain the count of all, Like the count of 0, 1, and 2. This can be followed by overwriting the array based on the frequency(count) of the values.

Approach: 

Take 3 variables to maintain the count of 0, 1 and 2.
Travel the array once and increment the corresponding counting variables
( let's consider count_0 = a, count_1 = b, count_2 = c )

Complexity Analysis

Time Complexity: O(N) + O(N), where N = size of the array. First O(N) for counting the number of 0’s, 1’s, 2’s, and second O(N) for placing them correctly in the original array.

Space Complexity: O(1) as we are not using any extra space.

In 2nd traversal of array, we will now over write the first ‘a’ indices / positions in array with ’0’, the next ‘b’ with ‘1’ and the remaining ‘c’ with ‘2’.

------------------------------------------------------------------------------------------------------------------

**Optimal Approach**

This problem is a variation of the popular Dutch National flag algorithm. 

This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:

arr[0….low-1] contains 0. [Extreme left part]

arr[low….mid-1] contains 1.

arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array

The middle part i.e. arr[mid….high] is the unsorted segment. So, hypothetically the array with different markers will look like the following:

![image](https://github.com/balotraprashant/a2z/assets/69639884/e09c6aca-6b32-4812-b7bd-483278482945)

In our case, we can assume that the entire given array is unsorted and so we will place the pointers accordingly. For example, if the given array is: [2,0,2,1,1,0], the array with the 3 pointers will look like the following:

![image](https://github.com/balotraprashant/a2z/assets/69639884/13d45231-0b2f-4d28-810c-2bdf687cf202)

Here, as the entire array is unsorted, we have placed the mid pointer in the first index and the high pointer in the last index. The low is also pointing to the first index as we have no other index before 0. Here, we are mostly interested in placing the ‘mid’ pointer and the ‘high’ pointer as they represent the unsorted part in the hypothetical array.

**Approach:**

The steps will be the following:

- First, we will run a loop that will continue until mid <= high.
- There can be three different values of mid pointer i.e. arr[mid]
- If arr[mid] == 0, we will swap arr[low] and arr[mid] and will increment both low and mid. Now the subarray from index 0 to (low-1) only contains 0.
- If arr[mid] == 1, we will just increment the mid pointer and then the index (mid-1) will point to 1 as it should according to the rules.
- If arr[mid] == 2, we will swap arr[mid] and arr[high] and will decrement high. Now the subarray from index high+1 to (n-1) only contains 2. In this step, we will do nothing to the mid-pointer as even after swapping, the subarray from mid to high(after decrementing high) might be unsorted. So, we will check the value of mid again in the next iteration.
- Finally, our array should be sorted.

**Dry Run:**

Assume the given array is [2,0,2,1,1,0]. The algorithm will be the following:

![image](https://github.com/balotraprashant/a2z/assets/69639884/ff7b7a31-c2a2-4655-972a-f6a069055430)

![image](https://github.com/balotraprashant/a2z/assets/69639884/7e3b4f11-68e5-45f7-91ec-9af515e4150b)

![image](https://github.com/balotraprashant/a2z/assets/69639884/159d9315-f17f-4ff4-9c80-07a1d0c93e68)


**Complexity Analysis**

- Time Complexity: O(N), where N = size of the given array.

  Reason: We are using a single loop that can run at most N times.

- Space Complexity: O(1) as we are not using any extra space.
