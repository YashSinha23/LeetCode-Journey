class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new ArrayDeque<>();

        int rows = mat.length;
        int cols = mat[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int distance = 1;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];

                // Going Up
                if(r-1 >= 0 && visited[r-1][c] == false){
                    if(mat[r-1][c] != 0){
                        mat[r-1][c] = distance;
                    }
                    queue.add(new int[]{r-1,c});
                    visited[r-1][c] = true;
                }

                // Going Down
                if(r+1 < mat.length && visited[r+1][c] == false){
                    if(mat[r+1][c] != 0){
                        mat[r+1][c] = distance;
                    }
                    queue.add(new int[]{r+1,c});
                    visited[r+1][c] = true;
                }

                // Going Right
                if(c-1 >= 0 && visited[r][c-1] == false){
                    if(mat[r][c-1] != 0){
                        mat[r][c-1] = distance;
                    }
                    queue.add(new int[]{r,c-1});
                    visited[r][c-1] = true;
                }

                // Going Left
                if(c+1 < mat[0].length && visited[r][c+1] == false){
                    if(mat[r][c+1] != 0){
                        mat[r][c+1] = distance;
                    }
                    queue.add(new int[]{r,c+1});
                    visited[r][c+1] = true;
                }
            }
            distance++;
        }

        return mat;
    }
}