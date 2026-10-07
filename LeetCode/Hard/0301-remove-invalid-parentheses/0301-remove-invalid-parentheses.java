class Solution {
    HashSet<String> set = new HashSet<>();
    int minRem = Integer.MAX_VALUE;
    public List<String> removeInvalidParentheses(String s) {
        helper(s,0,0,"",0);

        List<String> result = new ArrayList<>(set);

        return result;
    }
    public void helper(String s, int index,  int balance, String currStr,int rem){
        if(index == s.length()){
            if(balance==0){
                if(rem < minRem){
                    minRem = rem;
                    set.clear();
                    set.add(currStr);
                }else if(rem == minRem){
                    set.add(currStr);
                }
            }
            return;
        }

        char ch = s.charAt(index);

        if(ch == '('){
            helper(s,index+1,balance+1,currStr+ch,rem);
            helper(s, index+1, balance, currStr, rem+1);
        }else if(ch == ')'){
            if(balance > 0){
                helper(s, index+1,balance-1, currStr+ch,rem);
            }
            helper(s, index+1, balance, currStr, rem+1);
        }else{
            helper(s,index+1,balance,currStr+ch,rem);
        }
    }
}