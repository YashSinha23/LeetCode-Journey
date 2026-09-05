class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minarr = new int[n];

        int min = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            if(nums[i] < min){
                min = nums[i];
            }
            minarr[i] = min;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i] > max){
                max = nums[i];
            }

            int score = max - minarr[i];
            if(score <= k){
                return i;
            }
        }
        return -1;
    }
}