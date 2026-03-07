class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[] origin = {0,0};

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a,b) -> {
                int d1 = (a[0] - origin[0])*(a[0] - origin[0]) + (a[1] - origin[1])*(a[1] - origin[1]);
                int d2 = (b[0] - origin[0])*(b[0] - origin[0]) + (b[1] - origin[1])*(b[1] - origin[1]);
                return d1 - d2;
            }
        );
        
        for(int i=0; i<points.length; i++){
            heap.add(points[i]);
        }

        int[][] result = new int[k][2];

        for(int i=0; i<k; i++){
            result[i] = heap.poll();
        }

        return result;
        
    }
}