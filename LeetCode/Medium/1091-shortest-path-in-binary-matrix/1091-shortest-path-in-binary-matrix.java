class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[rows][cols];

        queue.add(new int[] { 0, 0 });
        visited[0][0] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];

                if (r == rows - 1 && c == cols - 1) {
                    return count;
                }

                // Going Diagonally bottom-right
                if (r + 1 < rows && c + 1 < cols && grid[r + 1][c + 1] == 0 && visited[r + 1][c + 1] == false) {
                    queue.add(new int[] { r + 1, c + 1 });
                    visited[r + 1][c + 1] = true;
                }
                // Going Diagonally bottom-left
                if (r + 1 < rows && c - 1 >= 0 && grid[r + 1][c - 1] == 0 && visited[r + 1][c - 1] == false) {
                    queue.add(new int[] { r + 1, c - 1 });
                    visited[r + 1][c - 1] = true;
                }
                // Going Diagonally Top-right
                if (r - 1 >= 0 && c - 1 >= 0 && grid[r - 1][c - 1] == 0 && visited[r - 1][c - 1] == false) {
                    queue.add(new int[] { r - 1, c - 1 });
                    visited[r - 1][c - 1] = true;
                }
                // Going Diagonally Top-Left
                if (r - 1 >= 0 && c + 1 < cols && grid[r - 1][c + 1] == 0 && visited[r - 1][c + 1] == false) {
                    queue.add(new int[] { r - 1, c + 1 });
                    visited[r - 1][c + 1] = true;
                }

                // Going Up
                if (r - 1 >= 0 && grid[r - 1][c] == 0 && visited[r - 1][c] == false) {
                    queue.add(new int[] { r - 1, c });
                    visited[r - 1][c] = true;
                }
                // Going Down
                if (r + 1 < rows && grid[r + 1][c] == 0 && visited[r + 1][c] == false) {
                    queue.add(new int[] { r + 1, c });
                    visited[r + 1][c] = true;
                }
                // Going Left
                if (c - 1 >= 0 && grid[r][c - 1] == 0 && visited[r][c - 1] == false) {
                    queue.add(new int[] { r, c - 1 });
                    visited[r][c - 1] = true;
                }
                // Going Right
                if (c + 1 < cols && grid[r][c + 1] == 0 && visited[r][c + 1] == false) {
                    queue.add(new int[] { r, c + 1 });
                    visited[r][c + 1] = true;
                }
            }
            if (visited[rows - 1][cols - 1]) {
                return count+1;
            }
        }
        return -1;
    }
}