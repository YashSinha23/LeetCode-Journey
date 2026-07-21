class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int l = m*n;
        int[] arr = new int[l];

        int idx = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[idx++] = grid[i][j];
            }
        }
        
        List<List<Integer>> mat = new ArrayList<>();
        for(int i=0; i<m; i++){
            mat.add(new ArrayList<>(Collections.nCopies(n,0)));
        }

        idx = 0;
        k = k % l;
        for(int i=0; i<mat.size(); i++){
            for(int j=0; j<mat.get(0).size(); j++){
                int index = (idx - k + l) % l;;
                int val = arr[index];
                idx++;
                mat.get(i).set(j,val);
            }
        }

        return mat;
    }
}