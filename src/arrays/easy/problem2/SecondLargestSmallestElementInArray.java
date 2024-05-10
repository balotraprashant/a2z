package arrays.easy.problem2;

public class SecondLargestSmallestElementInArray {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.

        if(n<2) return new int[] {-1, -1};

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            if (a[i]<smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            } else if (a[i]<secondSmallest && a[i]!=smallest) {
                secondSmallest = a[i];
            }

            if(a[i]>largest) {
                secondLargest = largest;
                largest = a[i];
            } else if (a[i]>secondLargest && a[i]!=largest) {
                secondLargest = a[i];
            }
        }

        return new int[] {secondLargest, secondSmallest};
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1, 7};
        int[] result = getSecondOrderElements(arr.length, arr);
        System.out.println(result[0] + " " + result[1]);
    }
}
