class Solution {
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    public String reverseParentheses(String s) {
        while(idx < s.length()){
            if(s.charAt(idx) == '('){
                idx++;
                String st = helper(s);
                sb.append(st);
            }else{
                sb.append(s.charAt(idx));
            }
            idx++;
        }
        return sb.toString();
    }

    private String helper(String s){
        StringBuilder rev = new StringBuilder();

        while(s.charAt(idx) != ')'){
            if(s.charAt(idx) == '('){
                idx++;
                String revst = helper(s);
                rev.append(revst);
            }else{
                rev.append(s.charAt(idx));
            }
            idx++;
        }
        return rev.reverse().toString();
    }
}