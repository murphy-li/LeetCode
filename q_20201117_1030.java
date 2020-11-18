/** class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<List<int[]>>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i, j, r0, c0);
                bucket.get(d).add(new int[]{i, j});
            }
        }
        int[][] ret = new int[R * C][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                ret[index++] = it;
            }
        }
        return ret;
    }

    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
**/
import java.util.Map.Entry;
import java.util.TreeMap;

class Solution {

    static class Distance{
        // 用于保存坐标
        int[] coordinate;
        // 用于保存和r0，c0的距离
        int distance;
    }
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<Distance> distanceList = new ArrayList<>();
        for(int i = 0; i < R; ++i){
            for(int j = 0; j < C; ++j){
                Distance dis = new Distance();
                dis.coordinate = new int[]{i, j};
                dis.distance = Math.abs(i - r0) + Math.abs(j - c0);
                distanceList.add(dis);
            }
        }
        Object [] array=distanceList.toArray();
        Arrays.sort(array, new Comparator<Object>() {
                public int compare(Object d1, Object d2) {
                    int distance1 = ((Distance)d1).distance;
                    int distance2 = ((Distance)d2).distance;
                    return distance1 - distance2;
                }
            });

        int [][]res = new int[array.length][2];
        int i = 0;
        for(Object distance: array){
            res[i++] = ((Distance)distance).coordinate;
        }
        return res;
    }
}