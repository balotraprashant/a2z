Problem Link: https://leetcode.com/problems/reverse-pairs/description/

------------------------------------------------------------------

## Optimal Approach

In order to solve this problem we will use the merge sort algorithm like we used in the problem count inversion with a slight modification of the merge() function. But in this case, the same logic will not work. In order to understand this, we need to deep dive into the merge() function.

Why the same logic of count inversion will not work?

- The merge function works by comparing two elements from two halves i.e. arr[left] and arr[right]. Now, the condition in the question was arr[i] > arr[j]. That is why we merged the logic. While comparing the elements, we counted the number of pairs.

- But in this case, the condition is arr[i] > 2*arr[j]. And, we cannot change the condition of comparing the elements in the merge() function. If we change the condition, the merge() function will fail to merge the elements. So, we need to check this condition and count the number of pairs separately.

Here, our approach will be to check, for every element in the sorted left half(sorted), how many elements in the right half(also sorted) can make a pair. Let’s try to understand, using the following example:

![image](https://github.com/user-attachments/assets/8ce5007f-e63f-4d49-97b3-d0b34450e429)

For the first element of the left half i.e. 6, we will start checking from index 0 of the right half i.e. arr2[]. Now, we can clearly see that the first two elements of arr2[] can make a pair with arr1[0] i.e. 6.

![image](https://github.com/user-attachments/assets/a878d59b-8199-4ec2-8556-64636211067e)

For the next element i.e. arr1[1], we will start checking from index 2(0-based indexing) i.e. where we stopped for the previous element. 

**Note**: This process will work because arr1[1] will always be greater than arr1[0] which concludes if arr2[0] and arr2[1] are making a pair with arr1[0], they will obviously make pairs with a number greater than arr1[0] i.e. arr1[1].

Thus before the merge step in the merge sort algorithm, we will calculate the total number of pairs each time.

**Approach:**

The steps are basically the same as they are in the case of the merge sort algorithm. The change will be just in the mergeSort() function:

- In order to count the number of pairs, we will keep a count variable, cnt, initialized to 0 beforehand inside the mergeSort().
- We will add the numbers returned by the previous mergeSort() calls.
- Before the merge step, we will count the number of pairs using a function, named countPairs().
- We need to remember that the left half starts from low and ends at mid, and the right half starts from mid+1 and ends at high.

The steps of the countPairs() function will be as follows:

- We will declare a variable, cnt, initialized with 0.
- We will run a loop from low to mid, to select an element at a time from the left half.
- Inside that loop, we will use another loop to check how many elements from the right half can make a pair.
- Lastly, we will add the total number of elements i.e. (right-(mid+1)) (where right = current index), to the cnt and return it.
