class Solution {
    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left)/2;

            long temp = (long) mid*(mid + 1)/2;

            if(temp > n){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left - 1;
    }
}