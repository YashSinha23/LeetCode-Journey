class Solution {
    public int maxProduct(int n) {
        int sec = 0;
        int fir = 0;
        int max = 0;
        while(n > 0){
            int digit = n%10;
            n = n/10;

            if(digit > fir){
                sec = fir;
                fir = digit;
            }else if(digit > sec){
                sec = digit;
            }

        }
        return sec*fir;
    }
}