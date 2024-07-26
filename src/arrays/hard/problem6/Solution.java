package arrays.hard.problem6;

public class Solution {
  public void merge(int[] left, int m, int[] right, int n) {
        int p1=m-1;
        int p2=n-1;
        int i=m+n-1;

        while(p2>=0) {
            if(p1>=0 && left[p1] > right[p2]){
                left[i--] = left[p1--];
            } else {
                left[i--] = right[p2--];
            }
        }
    }
}
