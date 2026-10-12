class Solution {
    public int maxSum(List<Integer> nums, int k) {
        

        int[] count = new int[30];

        for(int num : nums){
            for(int bit=0; bit<30; bit++){
                if(((num >> bit) & 1) == 1){
                    count[bit]++;
                }
            }
        }

        long result = 0;

        for(int i=0; i<k; i++){
            long x = 0;

            for(int bit = 29; bit>=0; bit--){
                if(count[bit] > 0){
                    x |= (1L << bit);
                    count[bit]--;
                }
            }

            result = (result + x * x) % 1_000_000_007L;
        }

        return (int) result;
    }
}