class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<prerequisites.length; i++){
            int value = prerequisites[i][0];
            map.computeIfAbsent(prerequisites[i][1], k -> new ArrayList<>()).add(prerequisites[i][0]);
            indegree[value]++;
        }

        boolean[] visited = new boolean[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
                visited[i] = true;
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int value : map.getOrDefault(curr, new ArrayList<>())){
                indegree[value]--;
                if(indegree[value] == 0){
                    queue.add(value);
                    visited[value] = true;
                }
            }
        }

        for(boolean node : visited){
            if(node == false){
                return false;
            }
        }

        return true;
    }
}