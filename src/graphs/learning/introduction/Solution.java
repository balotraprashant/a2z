package graphs.learning.introduction;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Driver {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
     
      Solution obj = new Solution();
      long ans = obj.count(n);
      System.out.println(ans);
    }
  }
}

// There are total n*(n-1)/2 possible edges. For every edge, there are to possible options, either we pick it or don\'t pick.
// So total number of possible graphs is 2n(n-1)/2.

public class Solution {
  static long count(int n) {
      return (long) Math.pow(2, (n*(n-1))/2);
  }
}

