class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> {
                    int s1 = nums1[a[0]] + nums2[a[1]];
                    int s2 = nums1[b[0]] + nums2[b[1]];
                    return s2 - s1;
                });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if(heap.size() < k){
                    heap.add(new int[] { i, j });
                }
                else{
                    int[] top = heap.peek();
                    int topSum = nums1[top[0]] + nums2[top[1]];

                    if(sum < topSum){
                        heap.poll();
                        heap.add(new int[] { i, j});
                    }else{
                        break;
                    }
                }

            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while(!heap.isEmpty()){
            int[] pair = heap.poll();
            result.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
        }

        return result;
    }
}