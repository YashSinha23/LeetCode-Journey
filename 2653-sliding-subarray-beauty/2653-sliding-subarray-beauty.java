class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] result = new int[nums.length - k + 1];
        int[] freq = new int[101];
        int left = 0;
        int winsize = 0;

        for(int i=0; i<nums.length; i++){
            freq[nums[i]+50]++;
            winsize = i - left + 1;

            if(winsize ==  k){
                int count = 0;
                for(int j=0; j<101; j++){
                    count += freq[j];
                    if(count >= x){
                        int val = j - 50;
                        if(val < 0){
                            result[left] = val;
                        }else{
                            result[left] = 0;
                        }
                        break;
                    }
                }
                freq[nums[left]+50]--;
                left++;
            }
        }
        return result;
    }
}