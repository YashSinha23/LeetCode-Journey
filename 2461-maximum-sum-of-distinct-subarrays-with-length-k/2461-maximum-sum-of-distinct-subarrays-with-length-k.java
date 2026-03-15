class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        long max = 0;
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            sum += nums[i];

            while(map.get(nums[i]) > 1){
                map.put(nums[left], map.get(nums[left])-1);
                sum -= nums[left];
                left++;
            }

            if(i - left + 1 == k){
                max = Math.max(max, sum);

                map.put(nums[left], map.get(nums[left])-1);
                sum -= nums[left];
                left++;
            }
        }
        return max;
    }
}