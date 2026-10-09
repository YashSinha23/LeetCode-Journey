class Solution {
    List<int[]> cord = new ArrayList<>();
    boolean touchedBoundary = false;
    public void solve(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length; 

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 'O'){
                    dfs(i,j,visited,board);
                    if(touchedBoundary){
                        cord.clear();
                    }else{
                        for (int[] pair : cord) {
                            board[pair[0]][pair[1]] = 'X';
                        }
                        cord.clear();
                    }
                    touchedBoundary = false;
                }
            }
        }
    }

    public void dfs(int row, int col, boolean[][] visited, char[][] board){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] == true || board[row][col] == 'X'){
            return;
        }

        if (row == 0 || row == board.length - 1 ||
            col == 0 || col == board[0].length - 1) {
            touchedBoundary = true;
        }
        
        cord.add(new int[]{row,col});
        visited[row][col] = true;

        dfs(row-1,col,visited,board);
        dfs(row+1,col,visited,board);
        dfs(row,col-1,visited,board);
        dfs(row,col+1,visited,board);
    }
}