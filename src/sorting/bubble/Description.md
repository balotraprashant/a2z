# Bubble Sort

The algorithm steps are as follows:

- First, we will select the range of the unsorted array. For that, we will run a loop(say i) that will signify the last index of the selected range. The loop will run backward from index n-1 to 0(where n = size of the array). The value i = n-1 means the range is from 0 to n-1, and similarly, i = n-2 means the range is from 0 to n-2, and so on.
- Within the loop, we will run another loop(say j, runs from 0 to i-1 though the range is from 0 to i) to push the maximum element to the last index of the selected range, by repeatedly swapping adjacent elements.
- Basically, we will swap adjacent elements(if arr[j] > arr[j+1]) until the maximum element of the range reaches the end.
- Thus, after each iteration, the last part of the array will become sorted. Like: after the first iteration, the array up to the last index will be sorted, and after the second iteration, the array up to the second last index will be sorted, and so on.
- After (n-1) iteration, the whole array will be sorted.

**Note**: Here, after each iteration, the array becomes sorted up to the last index of the range. That is why the last index of the range decreases by 1 after each iteration. This decrement is achieved by the outer loop and the last index is represented by variable i in the following code. And the inner loop(i.e. j) helps to push the maximum element of range [0….i] to the last index(i.e. index i).

**Dry Run:**

**Iteration 1:**

![image](https://github.com/user-attachments/assets/d7d963a7-50de-4d67-8c96-2c4881d02fac)

**Iteration 2:**

![image](https://github.com/user-attachments/assets/8a6fe324-0bc3-498e-addc-6de297efbe62)

**Iteration 3:**

![image](https://github.com/user-attachments/assets/15f5b692-0e69-4402-829d-d2be9e837b96)

**Iteration 4:**

![image](https://github.com/user-attachments/assets/6798d3dc-8107-46b8-a249-53cbc0ae9cc9)

**Iteration 5:**

![image](https://github.com/user-attachments/assets/99b84dc3-4d8b-48d7-a97e-c44934ca1614)


```
import java.util.*;

public class tUf {
    static void bubble_sort(int[] arr, int n) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("After bubble sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before Using Bubble Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        bubble_sort(arr, n);
    }

}
```
