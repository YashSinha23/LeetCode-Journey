class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for(int num : nums){
            left = Math.max(num,left);
            right += num;
        }

        while(left <= right){
            int mid = left + (right - left)/2;
            int max = Integer.MIN_VALUE;
            int sum = 0;
            int subarray = 1;
            for(int num : nums){
                sum += num;
                if(sum > mid){
                    sum = num;
                    subarray++;
                }
            }
            if(subarray > k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}