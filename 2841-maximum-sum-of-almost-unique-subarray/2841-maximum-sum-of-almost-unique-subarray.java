class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        long sum = 0;
        int unique = 0;
        long maxSum = 0;

        for(int i=0; i<nums.size(); i++){
            int val = nums.get(i);

            sum += val;
            map.put(val,map.getOrDefault(val,0)+1);
            if(map.get(val)==1){
                unique++;
            }

            if(i-left+1 == k){
                if(unique >= m){
                    maxSum = Math.max(maxSum, sum);
                }
                sum -= nums.get(left);
                if(map.get(nums.get(left))==1){
                    unique--;
                }
                map.put(nums.get(left), map.get(nums.get(left))-1);
                left++;
            }
        }
        return maxSum;
    }
}