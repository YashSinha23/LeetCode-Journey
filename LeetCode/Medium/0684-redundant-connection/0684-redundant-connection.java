class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];

            if (dfs(map, start, end, new HashSet<>())) {
                return edges[i];
            }

            map.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            map.computeIfAbsent(end, k -> new ArrayList<>()).add(start);
        }

        return new int[2];
    }

    public boolean dfs(HashMap<Integer, List<Integer>> map, int curr, int end, HashSet<Integer> visited){
        if(curr == end){
            return true;
        }

        visited.add(curr);

        for(int neighbour: map.getOrDefault(curr, new ArrayList<>())){
            if(!visited.contains(neighbour)){
                if(dfs(map, neighbour, end, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}