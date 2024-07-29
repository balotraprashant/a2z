Problem Link: https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

**Problem Statement**: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

**Naive Approach (Brute force)**

For each number between 1 to N, we will try to count the occurrence in the given array using linear search. And the element with occurrence as 2 will be the repeating number and the number with 0 occurrences will be the missing number.

Approach:

The steps are as follows:

- We will run a loop(say i) from 1 to N.
- For each integer, i, we will count its occurrence in the given array using linear search.
- We will store those two elements that have the occurrence of 2 and 0.
- Finally, we will return the elements.

------------------------------------------------------------------

**Better Approach (Using Hashing)** 

Instead of counting the occurrences every time, using the hashing technique, we will store the frequency of each element between 1 to N. Now, the element with frequency 2 will be the repeating number and the element with frequency 0 will be the missing number.

Note: Here, we can solve this problem using a hash array.

The steps are as follows:

- The range of the number is 1 to N. So, we need a hash array of size N+1 (as we want to store the frequency of N as well).
- We will iterate all the elements of the given array and update the hash array accordingly i.e. hash[a[i]] = hash[a[i]]+1.
- Now, we will iterate on the hash array and return the two elements with frequencies 2 and 0.

------------------------------------------------------------------
------------------------------------------------------------------
------------------------------------------------------------------
