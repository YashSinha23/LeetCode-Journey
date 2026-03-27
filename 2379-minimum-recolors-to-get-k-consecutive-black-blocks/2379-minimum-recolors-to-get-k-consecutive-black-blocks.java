class Solution {
    public int minimumRecolors(String blocks, int k) {

        int left = 0;
        int countW = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<blocks.length(); i++){
            char ch = blocks.charAt(i);
            if(ch == 'W'){
                countW++;
            }

            if(i-left+1 == k){
                min = Math.min(min, countW);
                
                if(blocks.charAt(left) == 'W'){
                    countW--;
                }
                left++;
            }
            
            
        }
        return min;
    }
}