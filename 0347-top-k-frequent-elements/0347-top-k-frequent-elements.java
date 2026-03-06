class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for(int num : nums){
            map.put(num,map.getOrDefault(num , 0)+1);
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        maxheap.addAll(map.keySet());
        
        for(int i=0; i<k;i++){
            result[i] = maxheap.poll();
        }

        return result;
    }
}