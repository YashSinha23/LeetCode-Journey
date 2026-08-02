class Solution {
    public long maxPairStrength(int[] nums) {
        long max = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                long gcd = findgcd(nums[i],nums[j]);


                long value = ((long)nums[i]*nums[j])/(gcd*gcd);
                
                max = Math.max(value,max);
            }
        }
        return max;
    }

    public long findgcd(long n1, long n2){
        while(n2 != 0){
            long temp = n1 % n2;
            n1 = n2;
            n2 = temp;
        }
        return Math.abs(n1);
    }
}