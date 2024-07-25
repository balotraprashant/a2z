package arrays.hard.problem5;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });

        ArrayList<int[]> res = new ArrayList<>();
        int[] current = new int[2];

        if(intervals.length>1){
            current[0] = intervals[0][0];
            current[1] = intervals[0][1];
        } else {
            return intervals;
        }
        

        for(int i=1; i<intervals.length; i++) {
            if(current[1]>=intervals[i][0] && current[1]<=intervals[i][1]){
                current[1] = intervals[i][1];
            } else {
                if(current[1]<=intervals[i][1]) {
                    res.add(current);
                    current = new int[2];
                    current[0] = intervals[i][0];
                    current[1] = intervals[i][1];
                }
            }

            if(i==intervals.length-1) {
                res.add(current);
            }
        }

        return res.toArray(new int[0][]);
    }
}
