class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < target){
                count++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                res.add(count++);
            }
        }

        return res;
    }
}