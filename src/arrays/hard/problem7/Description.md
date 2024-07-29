Problem Link: https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

**Problem Statement**: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

------------------------------------------------------------------

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

**Optimal Approach 1 (Using Maths)**

The idea is to convert the given problem into mathematical equations. Since we have two variables i.e. missing and repeating, we will try to form two linear equations. And then we will find the values of two variables using those equations.

Assume the repeating number to be X and the missing number to be Y.

In the array, the numbers are between 1 to N, and in that range, one number is missing and one number is occurring twice.

**Step 1**: Form equation 1:

Now, we know the summation of the first N numbers is:

```
Sn = (N*(N+1))/2
```

Let’s say, S = the summation of all the elements in the given array.

```
Therefore, S - Sn = X - Y…………………equation 1
```

**Step 2**: Form equation 2:

Now, we know the summation of squares of the first N numbers is:

```
S2n = (N*(N+1)*(2N+1))/6
```

Let’s say, S2 = the summation of squares of all the elements in the given array.

Therefore, S2-S2n = X2-Y2...................equation 2

From equation 2 we can conclude,

```
X+Y = (S2 - S2n) / (X-Y) [From equation 1, we get the value X-Y] ………… equation 3
```

From equation 1 and equation 3, we can easily find the value of X and Y. And this is what we want.

Note: Here, we are summing all the numbers and squares of all the numbers, so we should use a bigger data type(Like in C++, long long instead of int).

**Approach:**

Assume the repeating number to be X and the missing number to be Y.

The steps are as follows:

- First, find out the values of S and Sn and then calculate S - Sn (Using the above formulas).
- Then, find out the values of S2 and S2n and then calculate S2 - S2n.
- After performing steps 1 and 2, we will be having the values of X + Y and X - Y. Now, by substitution of values, we can easily find the values of X and Y.

------------------------------------------------------------------
------------------------------------------------------------------
