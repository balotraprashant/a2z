Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Link: https://leetcode.com/problems/majority-element/

**Optimal Approach: Moore’s Voting Algorithm**

Intuition:
If the array contains a majority element, its occurrence must be greater than the floor(N/2). Now, we can say that the count of minority elements and majority elements is equal up to a certain point in the array. So when we traverse through the array we try to keep track of the count of elements and the element itself for which we are tracking the count. 

After traversing the whole array, we will check the element stored in the variable. If the question states that the array must contain a majority element, the stored element will be that one but if the question does not state so, then we need to check if the stored element is the majority element or not. If not, then the array does not contain any majority element.

Approach: 

- Initialize 2 variables:
  Count –  for tracking the count of element
  Element – for which element we are counting

- Traverse through the given array.
- If Count is 0 then store the current element of the array as Element.
- If the current element and Element are the same increase the Count by 1.
- If they are different decrease the Count by 1.
- The integer present in Element should be the result we are expecting 

**Dry Run:**

The yellow-colored element represents the current element.

![image](https://github.com/balotraprashant/a2z/assets/69639884/2cf50c3a-7252-4f25-b2dc-a7ada3352a71)

![image](https://github.com/balotraprashant/a2z/assets/69639884/6830e56b-7960-4102-af07-c61d23451d36)

![image](https://github.com/balotraprashant/a2z/assets/69639884/bc480766-5706-42f6-855c-b58050d0f515)

![image](https://github.com/balotraprashant/a2z/assets/69639884/932c1d08-1a07-4bfe-9b47-85d9bc61310c)

Basically, we are trying to keep track of the occurrences of the majority element and minority elements dynamically. That is why, in iteration 4, the count becomes 0 as the occurrence of Element and the occurrence of the other elements are the same. So, they canceled each other. This is how the process works. The element with the most occurrence will remain and the rest will cancel themselves.

Here, we can see that 2 is the majority element. But if in this array, the last two elements were 3, then the Element variable would have stored 3 instead of 2. For that, we need to check if the Element is the majority element by traversing the array once more. But if the question guarantees that the given array contains a majority element, then we can bet the Element will store the majority one.
