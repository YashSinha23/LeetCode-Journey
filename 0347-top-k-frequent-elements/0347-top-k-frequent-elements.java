class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for(int num : nums){
            map.put(num,map.getOrDefault(num , 0)+1);
        }

        PriorityQueue<Integer> minheap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        
        for(int key : map.keySet()){
            minheap.add(key);

            if(minheap.size()>k){
                minheap.poll();
            }
        }

        for(int i=k-1; i>=0; i--){
            result[i] = minheap.poll();
        }



        return result;
    }
}