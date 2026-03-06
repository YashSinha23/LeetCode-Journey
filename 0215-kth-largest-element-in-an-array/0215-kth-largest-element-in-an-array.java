class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num: nums){
            maxheap.add(num);
        }

        for(int i=1; i<k; i++){
            maxheap.remove();
        }

        return maxheap.peek();
    }
}