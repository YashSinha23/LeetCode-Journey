class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '('){
                open++;
            }else{
                close++;
            }

            if(close > open){
                res += 1;
                close = 0;
            }
            if(open == close){
                open = 0;
                close = 0;
            }
        }

        if(open != close){
            res += open - close;
        }
        
        return res;
    }
}