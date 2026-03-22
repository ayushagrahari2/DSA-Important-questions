/*

3. Merge Intervals
Example: Input:[[1,3],[2,6],[8,10],[15,18]]
Output:[[1,6],[8,10],[15,18]]

*/
import java.util.*;

public class mergeIntervals {

    public static int[][] merge(int[][] intervals) {

        // Step 1: sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        for(int[] interval : intervals){

            // agar list empty hai ya overlap nahi hai
            if(res.size() == 0 || res.get(res.size()-1)[1] < interval[0]){
                res.add(interval);
            }
            else {
                // merge
                res.get(res.size()-1)[1] =
                    Math.max(res.get(res.size()-1)[1], interval[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args){
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }

}
