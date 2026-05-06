class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i=0; i<piles.length; i++){
            if(max < piles[i]){
                max = piles[i];
            }
        }

        int left = 1;
        int right = max;

        while(left <= right){
            int mid = left + (right - left)/2;
            long totalhrs = 0;

            for(int pile : piles){
                totalhrs += (pile + mid - 1) / mid;
            }

            if(totalhrs <= h){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}