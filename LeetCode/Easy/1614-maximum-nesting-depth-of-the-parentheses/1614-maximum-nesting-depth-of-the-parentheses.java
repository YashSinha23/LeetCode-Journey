class Solution {
    public int maxDepth(String s) {

        int depth = 0;
        int counter = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                counter++;
                depth = Math.max(counter, depth);
            }
            if(ch == ')'){
                counter--;
            }
        }

        return depth;
    }
}