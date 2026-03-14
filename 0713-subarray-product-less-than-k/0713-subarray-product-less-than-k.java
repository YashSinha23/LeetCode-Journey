class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int res = 0;
        int prod = 1;

        for(int i=0; i<nums.length; i++){
            prod *= nums[i];
            while(prod >= k && left <= i ){
                prod /= nums[left];
                left++;
            }
            res += (prod < k) ? i - left + 1 : 0;
        }
        return res;
    }
}