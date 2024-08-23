# Insertion Sort

**Approach:**

- Select an element in each iteration from the unsorted array(using a loop).
- Place it in its corresponding position in the sorted part and shift the remaining elements accordingly (using an inner loop and swapping).
- The “inner while loop” basically shifts the elements using swapping.

**Dry Run:**

- The purple color represents the unsorted array.
- The yellow color represents the current element that needs to be placed in the appropriate position.
- The green color represents the sorted array.

**Outer loop iteration 1(selected index i = 0):** The element at index i=0 is 13 and there is no other element on the left of 13. So, currently, the subarray up to the first index is sorted as it contains only element 13.

![image](https://github.com/user-attachments/assets/f311ee0d-0971-447b-98af-16c6af6524ff)

**Outer loop iteration 2(selected index i = 1):**

The selected element at index i=1 is 46. Now, we will try to move leftwards and put 46 in its correct position. Here, 46 > 13 and so 46 is already in its correct position. Now, the subarray up to the second index is sorted.

![image](https://github.com/user-attachments/assets/c6a8c37e-4f18-4390-a7e0-20c4ff0c5d63)

**Outer loop iteration 3(selected index i = 2):**

The selected element at index i=2 is 24. Now, we will try to move leftwards and put 24 in its correct position. Here, the correct position for 24 will be index 1. So, we will insert 24 in between 13 and 46. We will do it by swapping 24 and 46. Now, the subarray up to the third index is sorted.

![image](https://github.com/user-attachments/assets/687cf3e4-18c5-429b-9f49-35021de97efa)

**Outer loop iteration 4(selected index i = 3):**

The selected element at index i=3 is 52. Now, we will try to move leftwards and put 52 in its correct position. Here, the correct position for 52 will be index 3. So, we need not swap anything. Now, the subarray up to the fourth index is sorted.

![image](https://github.com/user-attachments/assets/d8a4e924-fb40-421e-b1e1-1175aa8d4ab0)

**Outer loop iteration 5(selected index i = 4):**

The selected element at index i=4 is 20. Now, we will try to move leftwards and put 20 in its correct position. Here, the correct position for 20 will be index 1. So, we need to swap adjacent elements until 20 reaches index 1. Now, the subarray up to the fifth index is sorted.

![image](https://github.com/user-attachments/assets/8816be91-72a8-41ad-8aae-24d589d663ab)

**Outer loop iteration 6(selected index i = 5):**

The selected element at index i=5 is 9. Now, we will try to move leftwards and put 9 in its correct position. Here, the correct position for 9 will be index 0. So, we need to swap adjacent elements until 9 reaches index 0. Now, the whole array is sorted.

![image](https://github.com/user-attachments/assets/d2d192d9-55ab-45b4-8cc5-d2f36de3137f)
**
