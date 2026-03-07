class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (heap.size() < k) {
                    heap.add(matrix[i][j]);
                } else if (matrix[i][j] < heap.peek()) {
                    heap.poll();
                    heap.add(matrix[i][j]);
                }
            }
        }
        return heap.peek();
    }
}