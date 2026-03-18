class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int winsize = n - k;

        int totalsum = 0;
        for(int num: cardPoints){
            totalsum += num;
        }

        int left = 0;
        int winsum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            winsum += cardPoints[i];

            if(i-left+1 == winsize){
                min = Math.min(min, winsum);
                winsum -= cardPoints[left];
                left++;
            }
        }
        return (winsize == 0)? totalsum : totalsum - min;
    }
}