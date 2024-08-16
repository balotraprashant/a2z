### Quick Sort

Quick Sort is a divide-and-conquer algorithm like the Merge Sort. But unlike Merge sort, this algorithm does not use any extra array for sorting (though it uses an auxiliary stack space). So, from that perspective, Quick sort is slightly better than Merge sort.

This algorithm is basically a repetition of two simple steps that are the following:

- Pick a pivot and place it in its correct place in the sorted array.
- Shift smaller elements(i.e. Smaller than the pivot) on the left of the pivot and larger ones to the right.

Now, let’s discuss the steps in detail considering the array {4,6,2,5,7,9,1,3}:

**Step 1**: The first thing is to choose the pivot. A pivot is basically a chosen element of the given array. The element or the pivot can be chosen by our choice. So, in an array a pivot can be any of the following:

- The first element of the array
- The last element of the array
- Median of array
- Any Random element of the array

After choosing the pivot(i.e. the element), we should place it in its correct position(i.e. The place it should be after the array gets sorted) in the array. For example, if the given array is {4,6,2,5,7,9,1,3}, the correct position of 4 will be the 4th position.

Note: Here, we have chosen the first element as our pivot. You can choose any element as per your choice.

**Step 2**: In step 2, we will shift the smaller elements(i.e. Smaller than the pivot) to the left of the pivot and the larger ones to the right of the pivot. In the example, if the chosen pivot is 4, after performing step 2 the array will look like: {3, 2, 1, 4, 6, 5, 7, 9}. 

From the explanation, we can see that after completing the steps, pivot 4 is in its correct position with the left and right subarray unsorted. Now we will apply these two steps on the left subarray and the right subarray recursively. And we will continue this process until the size of the unsorted part becomes 1(as an array with a single element is always sorted).

So, from the above intuition, we can get a clear idea that we are going to use recursion in this algorithm.

To summarize, the main intention of this process is to place the pivot, after each recursion call, at its final position, where the pivot should be in the final sorted array.

**Pseudocode:**

![image](https://github.com/user-attachments/assets/49d88665-3c63-4c6f-be5c-eddef699fac2)

Now, let’s understand how to implement the partition() function to get the partition index.

- Inside the function, we will first select the pivot(i.e. arr[low] in our case).
- Now, we will again take two-pointers i and j. The i pointer points to low and the j points to high.
- Now, the pointer i will move forward and find the first element that is greater than the pivot. Similarly, the pointer j will move backward and find the first element that is smaller than the pivot.
- Here, we need to add some checks like i <= high-1 and j >= low+1. Because it might happen that i is standing at high and trying to proceed or j is standing at low and trying to exceed.
- Once we find such elements i.e. arr[i] > pivot and arr[j] < pivot, and i < j, we will swap arr[i] and arr[j].
- We will continue step 3 and step 4, until j becomes smaller than i.
- Finally, we will swap the pivot element(i.e. arr[low]) with arr[j] and will return the index j i.e. the partition index.

**Pseudocode:**

![image](https://github.com/user-attachments/assets/85a65ace-f63f-4751-b22f-3eb688f52a6e)

```
import java.util.*;

class Solution {
    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) {
            while (arr.get(i) <= pivot && i <= high - 1) {
                i++;
            }

            while (arr.get(j) > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
    }

    static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here.
        qs(arr, 0, arr.size() - 1);
        return arr;
    }
}

public class tUf {
    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<>();
        arr = Arrays.asList(new Integer[] {4, 6, 2, 5, 7, 9, 1, 3});
        int n = arr.size();
        System.out.println("Before Using insertion Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        arr = Solution.quickSort(arr);
        System.out.println("After insertion sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

}




```
