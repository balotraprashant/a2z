**Problem Statement**: Given an array **nums** containing **n** distinct numbers in the range **[0, n]**, return the only number in the range that is missing from the array.

Link: https://leetcode.com/problems/missing-number/description/

----------------------------------------------------------------------------------------------------------------

### Using Hashing Approach

Using the hashing technique, we will store the frequency of each element of the given array. Now, the number( i.e. between 1 to N) for which the frequency will be 0, will be returned. Refer to the article link to know more about hashing.

**Approach:**

The algorithm steps are as follows:

- The range of the number is 1 to N. So, we need a hash array of size N+1 (as we want to store the frequency of N as well).
- Now, for each element in the given array, we will store the frequency in the hash array.
- After that, for each number between 1 to N, we will check the frequencies. And for any number, if the frequency is 0, we will return it.

**Dry run:**

Assume the given array = {1,3} and N = 3. The hash array will look like the following:

![image](https://github.com/balotraprashant/a2z/assets/69639884/9f534df4-9464-4621-8f3b-05a2ca75a1ac)

We can clearly see that for index 2 the frequency is 0 and so 2 is our answer.

```
public static int missingNumber(int []a, int N) {

        int hash[] = new int[N + 1]; //hash array

        // storing the frequencies:
        for (int i = 0; i < N - 1; i++)
            hash[a[i]]++;

        //checking the freqencies for numbers 1 to N:
        for (int i = 1; i <= N; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        // The following line will never execute.
        // It is just to avoid warnings.
        return -1;
    }
```
--------------------------------------------------------------------------------------------------
### Summation Approach

We know that the summation of the first N numbers is (N*(N+1))/2. We can say this S1. Now, in the given array, every number between 1 to N except one number is present. So, if we add the numbers of the array (say S2), the difference between S1 and S2 will be the missing number. Because, while adding all the numbers of the array, we did not add that particular number that is missing.

- Sum of first N numbers(S1) = (N*(N+1))/2
- Sum of all array elements = S2;
- The missing number = S1-S2

```
public static int missingNumber(int []a, int N) {

        //Summation of first N numbers:
        int sum = (N * (N + 1)) / 2;

        //Summation of all array elements:
        int s2 = 0;
        for (int i = 0; i < N - 1; i++) {
            s2 += a[i];
        }

        int missingNum = sum - s2;
        return missingNum;
    }
```
--------------------------------------------------------------------------------------------
### XOR Approach*

Two important properties of XOR are the following:

- XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
- XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.  ←Property 2

- Now, let’s XOR all the numbers between 1 to N.
   - xor1 = 1^2^.......^N

- Let’s XOR all the numbers in the given array.
   - xor2 = 1^2^......^N (contains all the numbers except the missing one).

- Now, if we again perform XOR between xor1 and xor2, we will get:
   - xor1 ^ xor2 = (1^1)^(2^2)^........^(missing Number)^.....^(N^N)

- Here, all the numbers except the missing number will form a pair and each pair will result in 0 according to the XOR property. The result will be = 0 ^ (missing number) = missing number (according to property 2).

So, if we perform the XOR of the numbers 1 to N with the XOR of the array elements, we will be left with the missing number.

```
public int missingNumber(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;
        int n = nums.length;

        for (int i=0; i<n; i++) {
            xor1 = xor1 ^ i;
            xor2 = xor2 ^ nums[i];
        }

        xor1 = xor1 ^ n;

        return xor1 ^ xor2;
    }
```
