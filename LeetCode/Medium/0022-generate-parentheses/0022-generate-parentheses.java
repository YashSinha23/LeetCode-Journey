class Solution {
    List<String> lt = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        helper("", 0, 0, n);

        return lt;
    }

    public void helper(String currentString, int open, int close, int n){
        if(open == n && close == n){
            lt.add(currentString);
            return;
        }
        if(open < n){
            helper(currentString + '(', open+1, close, n);
        }

        if(close < open){
            helper(currentString + ')' , open, close+1, n);
        }
    }
}