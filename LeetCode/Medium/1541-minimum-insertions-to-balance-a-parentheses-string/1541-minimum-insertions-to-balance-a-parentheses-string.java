class Solution {
    public int minInsertions(String s) {
        int index = 0;
        int open = 0;
        int need = 0;
        while(index < s.length()){
            char ch = s.charAt(index);

            if(ch == '('){
                open++;
            }else{
                if (index + 1 < s.length() && s.charAt(index + 1) == ')') {
                    index++;
                } else {
                    need++;
                }
                if (open > 0) {
                    open--;
                } else {
                    need++;
                }
            }
            index++;
        }

        int total = need + open * 2;

        return total;
    }
}