class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int maxlen = 0;
        long sum = 0;
        int win = 0;
        long val = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            win = i - left + 1;
            val = (long) nums[i] * win - sum;

            while(val > k){
                sum -= nums[left];
                left++;
                win = i - left + 1;
                val = (long) nums[i] * win - sum;
            }

            maxlen = Math.max(maxlen, win);
        }
        return maxlen;
    }
}