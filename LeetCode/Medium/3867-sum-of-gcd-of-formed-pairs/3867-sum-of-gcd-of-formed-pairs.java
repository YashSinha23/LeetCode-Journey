class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        int[] prefixGcd = new int[n];

        for(int i=0; i<n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            prefixGcd[i] = findgcd(nums[i], max);
        }
        Arrays.sort(prefixGcd);
        int left = 0;
        int right = n-1;
        long result = 0;
        while(left < right){
            result += findgcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return result;   
    }
    private int findgcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}