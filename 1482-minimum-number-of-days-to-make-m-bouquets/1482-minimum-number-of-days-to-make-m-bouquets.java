class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m * k > n){
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int bloom : bloomDay){
            left = Math.min(bloom, left);
            right = Math.max(bloom, right);
        }

        int res = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            
            int bouquets = 0;
            int flowers = 0;

            for(int bloom : bloomDay){
                if(bloom <= mid){
                    flowers++;

                    if(flowers == k){
                        bouquets++;
                        flowers = 0;
                    }
                }else{
                    flowers = 0;
                }
            }

            if(bouquets >= m){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
}