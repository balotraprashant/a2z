Problem Link: https://leetcode.com/problems/majority-element-ii/

![image](https://github.com/balotraprashant/a2z/assets/69639884/cc6c3082-d7f5-4483-a999-77e9eae0fa83)

**Edge Case**: Why we are adding extra checks like el2 != v[i] and el1 != v[i] in the first if statements? Let’s understand it using an example:
Assume the given array is: {2, 1, 1, 3, 1, 4, 5, 6}. Now apply the algorithm without the checks:

![image](https://github.com/balotraprashant/a2z/assets/69639884/82d15f55-5dfa-44d0-a3ca-e8106eecbff4)

We can clearly notice that in iteration 5, el1 and el2 both are set to 1 as cnt1 becomes 0 in iteration 4. But this is incorrect. So, to avoid this edge case, we are checking if the current element is already included in our elements, and if it is, we will not again include it in another variable.
