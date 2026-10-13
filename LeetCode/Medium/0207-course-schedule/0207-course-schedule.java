class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<prerequisites.length; i++){
            int value = prerequisites[i][0];
            map.computeIfAbsent(prerequisites[i][1], k -> new ArrayList<>()).add(prerequisites[i][0]);
            indegree[value]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int value : map.getOrDefault(curr, new ArrayList<>())){
                indegree[value]--;
                if(indegree[value] == 0){
                    queue.add(value);
                }
            }
            count++;
        }
        
        return count == numCourses;
    }
}