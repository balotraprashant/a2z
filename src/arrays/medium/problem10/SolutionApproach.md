Problem Link: https://leetcode.com/problems/set-matrix-zeroes/description/

## Brute Force Approach

The steps are the following:

- First, we will use two loops(nested loops) to traverse all the cells of the matrix.
- If any cell (i,j) contains the value 0, we will mark all cells in row i and column j with -1 except those which contain 0.
- We will perform step 2 for every cell containing 0.
- Finally, we will mark all the cells containing -1 with 0.
- Thus the given matrix will be modified according to the question.

Note: Here, we are assuming that the matrix does not contain any negative numbers. But if it contains negatives, we need to find some other ways to mark the cells instead of marking them with -1.

```
import java.util.*;

public class tUf {
    static void markRow(ArrayList<ArrayList<Integer>> matrix, int n, int m, int i) {
        // set all non-zero elements as -1 in the row i:
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    static void markCol(ArrayList<ArrayList<Integer>> matrix, int n, int m, int j) {
        // set all non-zero elements as -1 in the col j:
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // Set -1 for rows and cols that contains 0. Don't mark any 0 as -1:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    markRow(matrix, n, m, i);
                    markCol(matrix, n, m, j);
                }
            }
        }
        // Finally, mark all -1 as 0:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
```

--------------------------------------------------------------------------

## Better Approach

In the previous approach, we marked the cells with -1 while traversing the matrix. But in this approach, we are not marking the entire row and column instead, we are marking the ith index of row array i.e. row[i], and jth index of col array i.e. col[j] with 1. These marked indices of the two arrays, row and col will tell us for which rows and columns we need to change the values to 0. For any cell (i, j), if the row[i] or col[j] is marked with 1, we will change the value of cell(i, j) to 0.

Here we are marking the cells after traversal whereas in the previous case, we were marking the cells while traversal. That is how the time complexity reduces in this case.

The steps are as follows:

- First, we will declare two arrays: a row array of size N and a col array of size M and both are initialized with 0.
- Then, we will use two loops(nested loops) to traverse all the cells of the matrix.
- If any cell (i,j) contains the value 0, we will mark ith index of row array i.e. row[i] and jth index of col array col[j] as 1. It signifies that all the elements in the ith row and jth column will be 0 in the final matrix.
- We will perform step 3 for every cell containing 0.
- Finally, we will again traverse the entire matrix and we will put 0 into all the cells (i, j) for which either row[i] or col[j] is marked as 1.
- Thus we will get our final matrix.

--------------------------------------------------------------------------

## Optimal Approach

In the previous approach, the time complexity is minimal as the traversal of a matrix takes at least O(N*M)(where N = row and M = column). 

In this approach, we can just improve the space complexity. So, instead of using two extra matrices row and col, we will use the 1st row and 1st column of the given matrix to keep a track of the cells that need to be marked with 0. 

But here comes a problem. If we try to use the 1st row and 1st column to serve the purpose, the cell matrix[0][0] is taken twice. 

To solve this problem we will take an extra variable col0 initialized with 1. Now the entire 1st row of the matrix will serve the purpose of the row array. And the 1st column from (0,1) to (0,m-1) with the col0 variable will serve the purpose of the col array.

![image](https://github.com/balotraprashant/a2z/assets/69639884/300851db-8b6e-4dec-93e7-a205bbf16d01)

The steps are as follows:

- First, we will traverse the matrix and mark the proper cells of 1st row and 1st column with 0 accordingly. The marking will be like this: if cell(i, j) contains 0, we will mark the i-th row i.e. matrix[i][0] with 0 and we will mark j-th column i.e. matrix[0][j] with 0.
If i is 0, we will mark matrix[0][0] with 0 but if j is 0, we will mark the col0 variable with 0 instead of marking matrix[0][0] again.
- After step 1 is completed, we will modify the cells from (1,1) to (n-1, m-1) using the values from the 1st row, 1st column, and col0 variable.
We will not modify the 1st row and 1st column of the matrix here as the modification of the rest of the matrix(i.e. From (1,1) to (n-1, m-1)) is dependent on that row and column.
- Finally, we will change the 1st row and column using the matrix[0][0] and col0 variable values. Here also we will change the row first and then the column.
  - If matrix[0][0] = 0, we will change all the elements from the cell (0,1) to (0, m-1), to 0.
  - If col0 = 0, we will change all the elements from the cell (0,0) to (n-1, 0), to 0.

**Observations:** Why in the second step, we are first marking the matrix from the cell (1,1) to (n-1, m-1) and not from (0,0):

Let’s understand this using the following example:

Given matrix:

![image](https://github.com/balotraprashant/a2z/assets/69639884/1c198a2b-14d1-4e53-8e5d-5208e3d4dfd2)

Now, we will try to apply step 1 in the above matrix, col0 will be 0 as (3,0) contains 0 and it will look like the following:

![image](https://github.com/balotraprashant/a2z/assets/69639884/0fe1810d-eada-47be-ae49-f554264fd8a7)

- Now, in the second step we will try to start modifying the cells with value 0 from (0,0). First, we will change the value of (0,0) to 0 as col0 is marked with 0. After that, while checking for cell (0, 3) we will find that the value of (0,0) is 0. And we will again modify the cell (0,3) with 0. But this should not happen as (0,0) was initially 1 and that is why (0,3) should remain with the value 1.
This is why we cannot change the 1st row and 1st column on the first go as the rest of the matrix is dependent on them. If we do it, the modification of the matrix will be incorrect.

- In the 3rd step, why we are marking the 1st row first and then the 1st column:
  
- We can notice that the modification of the 1st row is dependent on matrix[0][0] and the modification of the 1st column is dependent on col0 which is an independent variable. Now, if we modify the 1st column first, matrix[0][0] might be changed and this will hinder the modification of the 1st row as well. But if we simply do the opposite, the 1st row will be changed first, based on the value matrix[0][0] and then the 1st column will be changed based on the variable col0. This is why the order of change matters.
