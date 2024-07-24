Problem Link: https://www.naukri.com/code360/problems/count-subarrays-with-given-xor_1115652

**Optimal Approach(Using Hashing):**

In this approach, we are going to use the concept of the prefix XOR to solve this problem. Here, the prefix XOR of a subarray ending at index i, simply means the XOR of all the elements of that subarray.

Observation: Assume, the prefix XOR of a subarray ending at index i is xr. In that subarray, we will search for another subarray ending at index i, whose XOR is equal to k. Here, we need to observe that if there exists another subarray ending at index i, with XOR k, then the prefix XOR of the rest of the subarray will be xr^k. The below image will clarify the concept:

![image](https://github.com/user-attachments/assets/0e233c0b-9f51-4984-93cc-e54139c01b40)

Question: Why do we need to set the value of 0 beforehand?

Let’s understand this using an example. Assume the given array is [3, 3, 1, 1, 1] and k is 3. Now, for index 0, we get the total prefix XOR as 3, and k is also 3. So, the prefix XOR xr^k will be = 3^3 = 0. Now, if the value is not previously set for the key 0 in the map, we will get the default value 0 and we will add 0 to our answer. This will mean that we have not found any subarray with XOR 3 till now. But this should not be the case as index 0 itself is a subarray with XOR k i.e. 3.
So, in order to avoid this situation we need to set the value of 0 as 1 on the map beforehand.
