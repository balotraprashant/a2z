package arrays.medium.problem12;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, left = 0, bottom = n - 1, right = m - 1;

        while(top <= bottom && left <= right) {
            // right
            for(int i=left; i<=right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // down
            for(int i=top; i<=bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // left
            if (top <= bottom) {
                for (int i = right; i >= left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // up
            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
