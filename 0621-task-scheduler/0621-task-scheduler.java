class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.addAll(map.values());

        Queue<int[]> cool = new ArrayDeque<>();
        int time=0;

        while(!heap.isEmpty() || !cool.isEmpty()){
            time++;
            if(!heap.isEmpty()){
                int freq = heap.poll();
                freq--;

                if(freq > 0){
                    cool.offer(new int[]{freq, time+n});
                }
            }
            if(!cool.isEmpty() && cool.peek()[1] == time){
                heap.offer(cool.poll()[0]);
            }
        }
        return time;
    }
}