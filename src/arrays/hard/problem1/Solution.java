package arrays.hard.problem1;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        res.add(row);

        for(int i=2; i<=numRows; i++) {
            res.add(generateRow(i));
        }

        return res;
    }

    public List<Integer> generateRow(int rowNum) {
        List<Integer> row = new ArrayList<>();
        
        int element = 1;
        row.add(element);

        for(int i=1; i<rowNum; i++) {
            element = element * (rowNum-i);
            element = element/i;

            row.add(element);
        }

        return row;
    }
}
