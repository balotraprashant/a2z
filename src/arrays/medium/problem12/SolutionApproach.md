Problem Link: https://leetcode.com/problems/spiral-matrix/

---------------------------------------------------------------------------------

**Approach:**

We will be using four loops to print all four sides of the matrix.

- 1st loop: This will print the elements from left to right.
- 2nd loop: This will print the elements from top to bottom.
- 3rd loop: This will print the elements from right to left.
- 4th loop: This will print the elements from bottom to top.

**Steps:**

Create and initialize variables:
 - top as starting row index
 - bottom as ending row index
 - left as starting column index
 - and right as ending column index

![image](https://github.com/balotraprashant/a2z/assets/69639884/9044efb8-9ef0-4aa6-a93b-41f5047ff85d)

In each outer loop traversal print the elements of a square in a clockwise manner.

- Print the top row, i.e. Print the elements of the top row from column index left to right and increase the count of the top so that it will move to the next row.
- Print the right column, i.e. Print the rightmost column from row index top to bottom and decrease the count of right.
- Print the bottom row, i.e. if top <= bottom, then print the elements of a bottom row from column right to left and decrease the count of bottom
- Print the left column, i.e. if left <= right, then print the elements of the left column from the bottom row to the top row and increase the count of left.
- Run a loop until all the squares of loops are printed.
