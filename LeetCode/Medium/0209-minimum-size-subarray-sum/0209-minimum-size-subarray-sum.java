class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;

        int sum = 0;
        int diff = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                diff = Math.min(diff, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return diff == Integer.MAX_VALUE ? 0 : diff;
    }
}