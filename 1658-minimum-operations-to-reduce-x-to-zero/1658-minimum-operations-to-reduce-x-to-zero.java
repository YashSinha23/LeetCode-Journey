class Solution {
    public int minOperations(int[] nums, int x) {
        int totalsum = 0;
        for(int num: nums){
            totalsum += num;
        }

        int target = totalsum - x;

        if(target < 0){
            return -1;
        }
        if(target == 0){
            return nums.length;
        }

        int sum = 0;
        int left = 0;
        int maxlen = -1;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            while(sum > target){
                sum -= nums[left];
                left++;
            }
            if(sum == target){
                maxlen = Math.max(maxlen, i - left + 1);
            }
        }
        if (maxlen == -1) return -1;
        return nums.length - maxlen;
    }
}