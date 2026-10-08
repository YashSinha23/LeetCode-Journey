class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    count++;
                    bfs(i,j,visited,grid);
                }
            }
        }

        return count;
    }

    public void bfs(int row, int col, boolean[][] visited, char[][] grid){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row,col});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            visited[curr[0]][curr[1]] = true;

            if(r > 0 && grid[r-1][c] == '1' && visited[r-1][c] == false){
                visited[r-1][c] = true;
                queue.add(new int[]{r-1, c});
            }
            if(r < grid.length - 1 && grid[r+1][c] == '1' && visited[r+1][c] == false){
                visited[r+1][c] = true;
                queue.add(new int[]{r+1, c});
            }
            if(c > 0 && grid[r][c-1] == '1' && visited[r][c-1] == false){
                visited[r][c-1] = true;
                queue.add(new int[]{r, c-1});
            }
            if(c < grid[0].length - 1 && grid[r][c+1] == '1' && visited[r][c+1] == false){
                visited[r][c+1] = true;
                queue.add(new int[]{r, c+1});
            }
        }
    }
}