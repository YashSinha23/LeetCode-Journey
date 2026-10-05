class Solution {
    int index = 0;
    public int scoreOfParentheses(String s) {
        return helper(s);
    }

    public int helper(String s) {
        int score = 0;

        while(index < s.length() && s.charAt(index) != ')'){
            index++;
            int innerScore = helper(s);
            index++;
            if(innerScore == 0){
                score += 1;
            } else {
                score += 2 * innerScore;
            }
        }
        return score;
    }
}