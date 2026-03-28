class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avg = new int[n];
        for (int i = 0; i < n; i++) {
            avg[i] = -1;
        }

        int left = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (i >= k * 2) {
                avg[i - k] = (int)(sum / (k * 2 + 1));
                sum -= nums[left];
                left++;
            }
        }
        return avg;
    }
}