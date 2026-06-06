class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftSumArr = leftSum(nums);
        int[] rightSumArr = rightSum(nums);

        int[] answer = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            answer[i] = Math.abs(leftSumArr[i] - rightSumArr[i]);
        }
        return answer;
    }

    public int[] leftSum(int[] nums){
        int sum = 0;
        int[] larr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            larr[i] = sum;
            sum += nums[i];
        }
        return larr;
    }
    public int[] rightSum(int[] nums){
        int sum = 0;
        int[] rarr = new int[nums.length];
        for(int i=nums.length - 1; i >= 0; i--){
            rarr[i] = sum;
            sum += nums[i];
        }
        return rarr;
    }
}