class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            boolean rotted = false;
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();

                int row = curr[0];
                int col = curr[1];

                // Going Up
                if(row - 1 >= 0 && grid[row-1][col] == 1){
                    grid[row-1][col] = 2;
                    queue.add(new int[]{row-1,col});
                    rotted = true;
                }

                // Going Down
                if(row + 1 < grid.length && grid[row+1][col] == 1){
                    grid[row+1][col] = 2;
                    queue.add(new int[]{row+1,col});
                    rotted = true;
                }

                // Going Left
                if(col - 1 >= 0 && grid[row][col-1] == 1){
                    grid[row][col-1] = 2;
                    queue.add(new int[]{row,col-1});
                    rotted = true;
                }

                // Going Right
                if(col + 1 < grid[0].length && grid[row][col+1] == 1){
                    grid[row][col+1] = 2;
                    queue.add(new int[]{row,col+1});
                    rotted = true;
                }
            }
            if(rotted){
                count++;
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    return - 1;
                }
            }
        }

        return count;
    }
}