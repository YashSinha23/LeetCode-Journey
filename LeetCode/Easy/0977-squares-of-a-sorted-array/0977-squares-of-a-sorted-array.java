class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        
        int left = 0;
        int right = n - 1;
        int[] arr = new int[n];

        for(int i=n-1; i>=0; i--){
            int lv = (int)Math.pow(nums[left],2);
            int rv = (int)Math.pow(nums[right],2);

            if(lv > rv){
                arr[i] = lv;
                left++;
            }else{
                arr[i] = rv;
                right--;
            }
        }
        return arr;
    }
}