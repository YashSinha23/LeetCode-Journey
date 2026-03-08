class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<String> heap = new PriorityQueue<>(
                (a, b) -> {
                    if (map.get(a).equals(map.get(b))) {
                        return b.compareTo(a);
                    }
                    return map.get(a) - map.get(b);
                });

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<String> list = new ArrayList<>();
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }

        Collections.reverse(list);

        return list;
    }
}