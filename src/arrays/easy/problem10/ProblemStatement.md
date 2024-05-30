**Problem Statement**: Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.

Link: https://leetcode.com/problems/max-consecutive-ones/

**Approach**:  We maintain a variable count that keeps a track of the number of consecutive 1’s while traversing the array. The other variable max_count maintains the maximum number of 1’s, in other words, it maintains the answer.

We start traversing from the beginning of the array. Since we can encounter either a 1 or 0 there can be two situations:-

- If  the value at the current index is equal to 1 we increase the value of count by one. After updating  the count variable if it becomes more than the max_count  update the max_count.
- If the value at the current index is equal to zero we make the variable count as 0 since there are no more consecutive ones.

See the illustration below for a better understanding

![image](https://github.com/balotraprashant/a2z/assets/69639884/425009d1-53e6-4ee3-a5a8-f1cb996061df)
