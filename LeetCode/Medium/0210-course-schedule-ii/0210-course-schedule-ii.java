class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] indegree = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<prerequisites.length; i++){
            int value  = prerequisites[i][0];
            indegree[value]++;
            map.computeIfAbsent(prerequisites[i][1], k -> new ArrayList<>()).add(prerequisites[i][0]);
        }

        int[] result = new int[n];
        int index = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0){
                queue.add(i);
                result[index++] = i;
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int value : map.getOrDefault(curr, new ArrayList<>())){
                indegree[value]--;
                if(indegree[value] == 0){
                    queue.add(value);
                    result[index++] = value;
                }
            }
            count++;
        }

        if(count == numCourses){
            return result;
        }

        return new int[0];
    }
}