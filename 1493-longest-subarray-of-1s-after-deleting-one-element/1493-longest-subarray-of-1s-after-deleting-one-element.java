class Solution {
    public int longestSubarray(int[] nums) {
        
        int left = 0;
        int count = 0;
        int max = 0;
        int ctz = 0;
        boolean isdeleted = false;

        for(int right=0; right<nums.length; right++){
            if(nums[right]==1){
                count++;
            }else{
                isdeleted = true;
                ctz++;
            }

            while(ctz > 1){
                if(nums[left]==0) ctz--;
                if(nums[left]==1) count--;
                left++;
            }

            max = Math.max(count,max);
        }
        if(isdeleted){
            return Math.max(0,max);
        }else{
            return Math.max(0,max-1);
        }
    }
}