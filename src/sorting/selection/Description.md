# Selection Sort

The algorithm steps are as follows:

- First, we will select the range of the unsorted array using a loop (say i) that indicates the starting index of the range.
- The loop will run forward from 0 to n-1. The value i = 0 means the range is from 0 to n-1, and similarly, i = 1 means the range is from 1 to n-1, and so on.
(Initially, the range will be the whole array starting from the first index.)
- Now, in each iteration, we will select the minimum element from the range of the unsorted array using an inner loop.
- After that, we will swap the minimum element with the first element of the selected range(in step 1). 
- Finally, after each iteration, we will find that the array is sorted up to the first index of the range. 

**Note**: Here, after each iteration, the array becomes sorted up to the first index of the range. That is why the starting index of the range increases by 1 after each iteration. This increment is achieved by the outer loop and the starting index is represented by variable i in the following code. And the inner loop(i.e. j) helps to find the minimum element of the range [i…..n-1].

**Dry run:**

Assume the given array is: {7, 5, 9, 2, 8}

**Outer loop iteration 1**:

The range will be the whole array starting from the 1st index as this is the first iteration. The minimum element of this range is 2(found using the inner loop).

![image](https://github.com/user-attachments/assets/e72a91bc-8a11-4215-96d6-2c696ca1c979)

**Outer loop iteration 2:**

The range will be from the [2nd index to the last index] as the array is sorted up to the first index. The minimum element of this range is 5(found using the inner loop).

![image](https://github.com/user-attachments/assets/25ce8391-6430-4107-a5a8-5bf94c2c8b4c)

**Outer loop iteration 3:**

The range will be from the [3rd index to the last index]. The minimum element of this range is 7(found using the inner loop).

![image](https://github.com/user-attachments/assets/2c22d373-c245-47d4-9e8d-29ee421778b7)

**Outer loop iteration 4:**

The range will be from the [4th index to the last index]. The minimum element of this range is 8(found using the inner loop).

![image](https://github.com/user-attachments/assets/222f6e68-ae12-45f2-bfc2-322be09323f3)

So, after 4 iterations(i.e. n-1 iterations where n = size of the array), the given array is sorted.

```
import java.util.*;

public class SelectionSort {
    static void selection_sort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int mini = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            //swap
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }

        System.out.println("After selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {

        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        selection_sort(arr, n);
    }
}
```
