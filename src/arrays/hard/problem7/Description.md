Problem Link: https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

**Naive Approach (Brute force)**

For each number between 1 to N, we will try to count the occurrence in the given array using linear search. And the element with occurrence as 2 will be the repeating number and the number with 0 occurrences will be the missing number.

Approach:

The steps are as follows:

- We will run a loop(say i) from 1 to N.
- For each integer, i, we will count its occurrence in the given array using linear search.
- We will store those two elements that have the occurrence of 2 and 0.
- Finally, we will return the elements.
