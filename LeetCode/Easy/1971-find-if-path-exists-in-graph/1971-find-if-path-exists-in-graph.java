class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return dfs(source, graph, destination, visited);
    }

    public boolean dfs(int node, HashMap<Integer, List<Integer>> graph, int destination, boolean[] visited){
        if(node == destination){
            return true;
        }

        visited[node] = true;

        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour, graph, destination, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}