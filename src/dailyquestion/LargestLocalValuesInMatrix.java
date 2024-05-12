package dailyquestion;//Problem Link: https://leetcode.com/problems/largest-local-values-in-a-matrix/description/?envType=daily-question&envId=2024-05-12

public class LargestLocalValuesInMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int m = n-2;

        int[][] ans = new int[m][m];

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                ans[i][j] = largestLocalUtil(grid, i, j);
            }
        }
        return ans;
    }


    public int largestLocalUtil(int[][] grid, int x, int y) {
        int max = 0;

        for(int i=x; i<x+3; i++){
            for(int j=y; j<y+3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
