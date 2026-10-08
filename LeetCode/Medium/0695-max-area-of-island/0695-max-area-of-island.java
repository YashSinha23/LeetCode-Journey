class Solution {
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] visited = new boolean[rows][cols];

        int maxArea = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    count = 0;
                    dfs(i,j,visited,grid);
                    maxArea = Math.max(maxArea,count);
                }
            }
        }

        return maxArea;
    }

    public void dfs(int rows, int cols, boolean[][] visited, int[][] grid){
        if(rows < 0 || rows >= grid.length || cols < 0 || cols >= grid[0].length || visited[rows][cols] == true || grid[rows][cols] == 0){
            return;
        }

        visited[rows][cols] = true;
        count++;

        dfs(rows-1,cols,visited,grid);
        dfs(rows+1,cols,visited,grid);
        dfs(rows,cols+1,visited,grid);
        dfs(rows,cols-1,visited,grid);
    }
}